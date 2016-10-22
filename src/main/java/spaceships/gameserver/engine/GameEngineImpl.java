package spaceships.gameserver.engine;

import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.physic.PhysicEngine;
import spaceships.gameserver.physic.PhysicEngineImpl;
import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;
import java.util.Queue;

public class GameEngineImpl implements GameEngine{

	private PhysicEngine physicEngine = new PhysicEngineImpl(1/60, 8, 3);

	public List<Notification> process(Queue<Action> actions) {
//		TODO: make priority for events and apply events according to priority.
//		TODO: for example if ship is broken we should not need to process movements of this ship
		return null;
	}
}
