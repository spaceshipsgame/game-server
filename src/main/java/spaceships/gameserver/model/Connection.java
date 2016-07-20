package spaceships.gameserver.model;

import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.server.protocol.action.PlayerAction;
import spaceships.gameserver.server.protocol.notification.Notification;

public interface Connection {

    void sendToClient(Notification ... notifications);

    void sendToServer(PlayerAction action);

    PlayerActionQueue getActionQueue();

    void setActionQueue(PlayerActionQueue actionQueue);
}
