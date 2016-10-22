package spaceships.gameserver.engine;

import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.physic.PhysicEngine;
import spaceships.gameserver.physic.PhysicEngineImpl;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;

public class GameEngineImpl implements GameEngine{

	private PhysicEngine physicEngine = new PhysicEngineImpl(1/60, 8, 3);

	public List<Notification> processEvents(List<Event> events) {
//		TODO: make priority for events and apply events according to priority.
//		TODO: for example if ship is broken we should not need to process movements of this ship
		return null;
	}
}
