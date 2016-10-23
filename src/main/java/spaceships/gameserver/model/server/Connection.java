package spaceships.gameserver.model.server;

import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.Queue;


public interface Connection {

    void sendToClient(Notification ... notifications);

    void sendToServer(Action action);

    Queue<Action> getActions();

    void setActions(Queue<Action> actions);
}
