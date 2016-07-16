package spaceships.gameserver.server;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.server.protocol.notification.Notification;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NotificationQueue {

	private Queue<Notification> buffer;

	public NotificationQueue() {
		buffer = new LinkedList<>();
	}

	public boolean offer(Notification notification) {
		return buffer.offer(notification);
	}

	public Notification poll() {
		return buffer.poll();
	}

	public boolean isEmpty() {
		return buffer.isEmpty();
	}
}
