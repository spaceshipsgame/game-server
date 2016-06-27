package netty.handlers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.log4j.Logger;

/**
 * Created by DimaMir on 24.06.2016.
 */
public class JsonHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = Logger.getLogger(JsonHandler.class);

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
    }
}
