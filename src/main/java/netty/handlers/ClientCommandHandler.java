package netty.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import protocol.PlayerActionQueue;
import protocol.actions.LogInAction;
import protocol.actions.MoveAction;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.log4j.Logger;

public class ClientCommandHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = Logger.getLogger(ClientCommandHandler.class);

    private PlayerActionQueue actionQueue;
    private boolean isAuthorized;

    public ClientCommandHandler(PlayerActionQueue playerActionQueue) {
        this.actionQueue = playerActionQueue;
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
            logger.error("JSON parsing exeption", exeption);
        }

        if(putIfLogInCommand(json)) return;
        if(putIfMoveCommand(json)) return;
        if(putIfShotCommand(json)) return;

        logger.warn("Wrong JSON format");
    }

    public boolean putIfMoveCommand(JsonObject json){
        JsonElement button = json.get("button");
        if(button != null){
            boolean isPressed = json.get("press").getAsBoolean();
            MoveAction command = new MoveAction(button.getAsString(), isPressed);
            if(command.getButton() != null) {
                actionQueue.offer(command);
                logger.warn("Move command received");
                return true;
            }
            logger.warn("Wrong move command");
            return false;
        }
        return false;
    }

    public boolean putIfShotCommand(JsonObject json){
        return false;
    }

    public boolean putIfLogInCommand(JsonObject json){
        if(!isAuthorized){
            JsonElement playerHashElement = json.get("playerHash");
            if(playerHashElement != null){
                isAuthorized = true;
                actionQueue.offer(new LogInAction(playerHashElement.getAsString()));
                return true;
            }
            logger.warn("Wrong command. Authentification required");
            return true;
        }
        return false;
    }
}
