package spaceships.gameserver.netty.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.model.server.Player;
import spaceships.gameserver.netty.NettyConnection;
import spaceships.gameserver.server.ConnectionResolver;
import spaceships.gameserver.server.protocol.action.MoveAction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.log4j.Logger;

public class ClientCommandHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = Logger.getLogger(ClientCommandHandler.class);

    private ConnectionResolver connectionResolver;
    private Connection connection;
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
        } catch (Exception exeption){
            logger.error("JSON parsing exception", exeption);
        }

        if(!isAuthorized) {
            if (checkIfLogIn(json)) {
                JsonElement playerHashElement = json.get("playerHash");
                String playerHash = playerHashElement.getAsString();
                Connection connection = new NettyConnection(ctx.channel());
                Player player = connectionResolver.attachToPlayer(connection, playerHash);
                if(player != null) {
                    this.connection = connection;
                    isAuthorized = true;
                }
            }
            logger.warn("Wrong command. Authentication required");
        }

        if(proccessIfMoveAction(json)) return;
        if(proccessIfShotAction(json)) return;

        logger.warn("Wrong JSON format");
    }

    public boolean proccessIfMoveAction(JsonObject json){
        JsonElement button = json.get("button");
        if(button != null){
            boolean isPressed = json.get("press").getAsBoolean();
            MoveAction command = new MoveAction(button.getAsString(), isPressed);
            if(command.getButton() != null) {
                connection.sendToServer(command);
                logger.warn("Move command received");
                return true;
            }
            logger.warn("Wrong move command");
            return false;
        }
        return false;
    }

    public boolean proccessIfShotAction(JsonObject json){
        return false;
    }

    public boolean checkIfLogIn(JsonObject json){
        JsonElement playerHashElement = json.get("playerHash");
        return playerHashElement != null;
    }
}
