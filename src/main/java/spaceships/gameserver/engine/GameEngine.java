package spaceships.gameserver.engine;

import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;
import java.util.Queue;

public interface GameEngine {

    List<Notification> process(Queue<Action> actions);
}
