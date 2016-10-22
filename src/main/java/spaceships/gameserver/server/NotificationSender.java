package spaceships.gameserver.server;

import spaceships.gameserver.server.protocol.notification.Notification;

import java.util.List;

public interface NotificationSender {

	void sendNotifications(List<Notification> notifications);

}
