package spaceships.gameserver.server;

import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.GameEngineImpl;
import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionHandlerChainFactory;
import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;
import java.util.TimerTask;

public class GameTickTask extends TimerTask {

	private GameEngine gameEngine = new GameEngineImpl();
	private PlayerActionQueue playerActionQueue;
	private PlayerActionProcessor playerActionProcessor;
	private NotificationSender notificationSender = new NotificationSenderImpl();

	public GameTickTask() {

		playerActionProcessor = new PlayerActionProcessorImpl();
	}

	@Override
	public void run() {
		List<Event> events = playerActionProcessor.processActions(playerActionQueue);
		List<Notification> notifications = gameEngine.processEvents(events);
		notificationSender.sendNotifications(notifications);
	}

	public PlayerActionQueue getPlayerActionQueue() {
		return playerActionQueue;
	}

	public void setPlayerActionQueue(PlayerActionQueue playerActionQueue) {
		this.playerActionQueue = playerActionQueue;
	}
}
