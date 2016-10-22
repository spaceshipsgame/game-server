package spaceships.gameserver.server;

import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.GameEngineImpl;
import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;
import java.util.Queue;
import java.util.TimerTask;

public class GameTickTask extends TimerTask {

	private GameEngine gameEngine = new GameEngineImpl();
	private Queue<Action> playerActionQueue;
	private NotificationSender notificationSender = new NotificationSenderImpl();

	@Override
	public void run() {
		List<Notification> notifications = gameEngine.process(playerActionQueue);
		notificationSender.sendNotifications(notifications);
	}

	public Queue<Action> getPlayerActionQueue() {
		return playerActionQueue;
	}

	public void setPlayerActionQueue(Queue<Action> playerActionQueue) {
		this.playerActionQueue = playerActionQueue;
	}
}
