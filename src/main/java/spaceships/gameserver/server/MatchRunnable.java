package spaceships.gameserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionQueue;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MatchRunnable implements Runnable {

	@Autowired
	private GameEngine gameEngine;

	@Autowired
	private PlayerActionQueue playerActionQueue;

	@Autowired(required = false)
	private PlayerActionHandler chain;

	@Autowired
	private EventQueue eventQueue;

	@Autowired
	private NotificationQueue notificationQueue;

	@Autowired
	private PlayerActionProcessor playerActionProcessor;

	@Autowired
	private NotificationSender notificationSender;

	@Override
	public void run() {
		playerActionProcessor.processActions();
		gameEngine.proccessEvents();
		notificationSender.sendNotifications();
	}
}
