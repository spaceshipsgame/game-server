package spaceships.gameserver.server;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.GameEngineImpl;
import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionQueue;

import java.util.TimerTask;

public class GameTickTask extends TimerTask {

	private GameEngine gameEngine;
	private PlayerActionQueue playerActionQueue;
	private PlayerActionHandler chain;
	private EventQueue eventQueue;
	private NotificationQueue notificationQueue;
	private PlayerActionProcessor playerActionProcessor;
	private NotificationSender notificationSender;

	public GameTickTask() {
		NotificationQueue notificationQueue = new NotificationQueue();
		EventQueue eventQueue = new EventQueue();
		GameEngine gameEngine = new GameEngineImpl(eventQueue, notificationQueue);
	}

	@Override
	public void run() {
		playerActionProcessor.processActions();
		gameEngine.processEvents();
		notificationSender.sendNotifications();
	}

	public PlayerActionQueue getPlayerActionQueue() {
		return playerActionQueue;
	}

	public void setPlayerActionQueue(PlayerActionQueue playerActionQueue) {
		this.playerActionQueue = playerActionQueue;
	}
}
