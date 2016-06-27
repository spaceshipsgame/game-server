package netty.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import game.protocol.LogInCommand;
import game.protocol.MoveCommand;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.log4j.Logger;
import workers.ClientCommandProcessor;

/**
 * Created by DimaMir on 20.03.2016.
 */
public class ClientCommandHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = Logger.getLogger(ClientCommandHandler.class);

    private ClientCommandProcessor processor;

    public ClientCommandHandler(ClientCommandProcessor processor) {
        this.processor = processor;
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
            logger.warn("Test success");
        }

        if(putIfMoveCommand(json)) return;
        if(putIfShotCommand(json)) return;
        if(putIfLogInCommand(json)) {
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("clientKeyHash", "999");
            ctx.channel().writeAndFlush(new TextWebSocketFrame(jsonObj.toString()));
            return;
        }

        logger.warn("Wrong JSON format");
    }

    public boolean putIfMoveCommand(JsonObject json){
        JsonElement button = json.get("button");
        if(button != null){
            boolean isPressed = json.get("press").getAsBoolean();
            MoveCommand command = new MoveCommand(button.getAsString(), isPressed);
            if(command.getButton() != null) {
                processor.put(command);
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
        JsonElement login = json.get("login");
        if(login != null){
            String password = json.get("password").getAsString();
            if(password != null) {
                LogInCommand command = new LogInCommand(login.getAsString(), password);
                processor.put(command);
                logger.warn("Log in command received");
                return true;
            }
            logger.warn("Wrong log in command");
            return false;
        }
        logger.warn("Wrong log in command");
        return false;
    }
}
