package spaceships.gameserver.server;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spaceships.gameserver.model.server.Player;
import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationSenderImpl implements NotificationSender {

	private NotificationQueue notificationQueue;

	public NotificationSenderImpl(NotificationQueue notificationQueue) {
		this.notificationQueue = notificationQueue;
	}

	@Override
	public void sendNotifications() {
		Map<Player, List<Notification>> notifications = notificationQueue.getAll();

	}

}
