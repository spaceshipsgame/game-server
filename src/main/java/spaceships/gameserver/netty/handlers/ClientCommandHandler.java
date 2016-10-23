package spaceships.gameserver.netty.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.model.server.Player;
import spaceships.gameserver.netty.NettyConnection;
import spaceships.gameserver.server.ConnectionResolver;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.log4j.Logger;
import spaceships.gameserver.server.protocol.action.MoveShipAction;

import java.util.Objects;

public class ClientCommandHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = Logger.getLogger(ClientCommandHandler.class);

    private ConnectionResolver connectionResolver;
    private Connection connection;
    private Player player;
    private boolean isAuthorized;

    public ClientCommandHandler(ConnectionResolver connectionResolver) {
        this.connectionResolver = connectionResolver;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String message = msg.text();
        JsonParser parser = new JsonParser();
        JsonObject json= null;
        try {
            JsonElement element = parser.parse(message);
            json = element.getAsJsonObject();
        } catch (Exception e){
            logger.error("JSON parsing exception", e);
        }

        if(!isAuthorized) {
            if (checkIfLogIn(json)) {
                JsonElement playerHashElement = json.get("playerHash");
                String playerHash = playerHashElement.getAsString();
                Connection connection = new NettyConnection(ctx.channel());
                player = connectionResolver.attachToPlayer(connection, playerHash);
                if(player != null) {
                    this.connection = connection;
                    isAuthorized = true;
                }
            }
            logger.warn("Wrong command. Authentication required");
        }

        if(processIfMoveAction(json)) return;
        if(processIfShotAction(json)) return;

        logger.warn("Wrong JSON format");
    }

    public boolean processIfMoveAction(JsonObject json){
        JsonElement button = json.get("button");
        if(button != null){
            JsonElement isActiveJson = json.get("press");
            boolean isActive;
            if(isActiveJson != null){
                isActive = isActiveJson.getAsBoolean();
            } else {
                logger.warn("Wrong move command");
                return false;
            }
            MoveShipAction.MoveType moveType = MoveShipAction.MoveType.parse(button.getAsString());
            if(moveType != null){
                MoveShipAction action = new MoveShipAction(player, moveType, isActive);
                connection.sendToServer(action);
                logger.warn("Move command received");
                return true;
            }
            logger.warn("Wrong move command");
            return false;
        }
        return false;
    }

    public boolean processIfShotAction(JsonObject json){
        return false;
    }

    public boolean checkIfLogIn(JsonObject json){
        JsonElement playerHashElement = json.get("playerHash");
        return playerHashElement != null;
    }
}
