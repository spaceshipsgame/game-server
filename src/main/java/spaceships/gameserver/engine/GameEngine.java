package spaceships.gameserver.engine;

import spaceships.gameserver.server.NotificationQueue;

public class GameEngine {

	private EventQueue eventQueue;
	private NotificationQueue notificationQueue;

	public GameEngine(EventQueue eventQueue, NotificationQueue notificationQueue) {
		this.eventQueue = eventQueue;
		this.notificationQueue = notificationQueue;
	}

	public void proccessEvents() {
		while (!eventQueue.isEmpty()) {
			eventQueue.poll().execute();
		}
	}
}
