package spaceships.gameserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.model.Match;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MatchManager {

	@Autowired
	private GameEngine gameEngine;

	@Autowired
	private MatchRunnable runnable;

	private Match match;

	private Thread worker;

	public MatchManager() {
	}
	
	public MatchManager(Match match) {
		this.match = match;
		// NotificationQueue notificationQueue = new NotificationQueue();
		// gameEngine = new GameEngine(notificationQueue);
		// this.runnable = new MatchRunnable();
		// worker = new Thread(this.runnable);
	}

	public void startMatch() {
		worker.start();
	}
}
