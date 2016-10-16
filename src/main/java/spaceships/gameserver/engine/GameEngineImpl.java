package spaceships.gameserver.engine;

import spaceships.gameserver.physic.PhysicEngine;
import spaceships.gameserver.physic.PhysicEngineImpl;
import spaceships.gameserver.server.NotificationQueue;

public class GameEngineImpl implements GameEngine{

	private PhysicEngine physicEngine;

	private EventQueue eventQueue;
	private NotificationQueue notificationQueue;

	public GameEngineImpl(EventQueue eventQueue, NotificationQueue notificationQueue) {
		this.eventQueue = eventQueue;
		this.notificationQueue = notificationQueue;
		this.physicEngine = new PhysicEngineImpl(1/60, 8, 3);
	}

	public void processEvents() {
//		TODO: make priority for events and apply events according to priority.
//		TODO: for example if ship is broken we should not need to process movements of this ship
		while (!eventQueue.isEmpty()) {
			eventQueue.poll().execute();
		}
	}
}
