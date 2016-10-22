package spaceships.gameserver.server;

import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.action.PlayerAction;

import java.util.List;

public interface PlayerActionProcessor {

    List<Event> processActions(PlayerActionQueue actionQueue);
}
