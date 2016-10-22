package spaceships.gameserver.engine;

import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;

public interface GameEngine {

    List<Notification> processEvents(List<Event> events);
}
