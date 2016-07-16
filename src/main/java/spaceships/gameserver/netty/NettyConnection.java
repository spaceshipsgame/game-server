package spaceships.gameserver.netty;

import io.netty.channel.Channel;
import spaceships.gameserver.model.Connection;

public class NettyConnection implements Connection{

    private Channel channel;

    public NettyConnection(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void sendMessage(String message) {
        //TODO: here should be code to write information to channel
        //problem that i dont know output model than param was output model object not String
    }
}
