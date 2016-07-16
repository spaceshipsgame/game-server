package spaceships.gameserver.server;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionQueue;

public class MatchRunnable implements Runnable {

	private GameEngine gameEngine;
	private PlayerActionQueue playerActionQueue;
	private PlayerActionHandler chain;
	private EventQueue eventQueue;
	private NotificationQueue notificationQueue;
	private PlayerActionProcessor playerActionProcessor;
	private NotificationSender notificationSender;

	@Override
	public void run() {
		playerActionProcessor.processActions();
		gameEngine.proccessEvents();
	}
}
