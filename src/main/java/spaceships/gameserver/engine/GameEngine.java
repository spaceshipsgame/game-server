package spaceships.gameserver.engine;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import spaceships.gameserver.server.NotificationQueue;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameEngine  {

	@Autowired
	private EventQueue eventQueue;
	
	@Autowired
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
