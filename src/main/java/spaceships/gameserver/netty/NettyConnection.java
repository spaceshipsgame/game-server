package spaceships.gameserver.netty;

import io.netty.channel.Channel;
import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.server.protocol.action.PlayerAction;
import spaceships.gameserver.server.protocol.notification.Notification;

public class NettyConnection implements Connection{

    private Channel channel;
    private PlayerActionQueue actionQueue;

    public NettyConnection(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void sendToClient(Notification... notifications) {
        //TODO: here should be code to write information to channel
        //problem that i dont know output model than param was output model object not String
    }

    @Override
    public void sendToServer(PlayerAction action) {
        actionQueue.offer(action);
    }

    public PlayerActionQueue getActionQueue() {
        return actionQueue;
    }

    public void setActionQueue(PlayerActionQueue actionQueue) {
        this.actionQueue = actionQueue;
    }
}
