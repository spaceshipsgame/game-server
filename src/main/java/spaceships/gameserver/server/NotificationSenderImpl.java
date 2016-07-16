package spaceships.gameserver.server;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class NotificationSenderImpl implements NotificationSender {

	private NotificationQueue notificationQueue;

	public NotificationSenderImpl(NotificationQueue notificationQueue) {
		this.notificationQueue = notificationQueue;
	}

	@Override
	public void sendNotifications() {
		while (!notificationQueue.isEmpty()) {
			notificationQueue.poll().send();
		}
	}

}
