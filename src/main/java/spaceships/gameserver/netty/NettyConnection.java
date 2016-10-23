package spaceships.gameserver.netty;

import io.netty.channel.Channel;
import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.Queue;

public class NettyConnection implements Connection{

    private Channel channel;

    private Queue<Action> actions;

    public NettyConnection(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void sendToClient(Notification... notifications) {
        //TODO: here should be code to write information to channel
        //problem that i dont know output model than param was output model object not String
    }

    @Override
    public void sendToServer(Action action) {
        actions.offer(action);
    }

    public Queue<Action> getActions() {
        return actions;
    }

    public void setActions(Queue<Action> actions) {
        this.actions = actions;
    }
}
