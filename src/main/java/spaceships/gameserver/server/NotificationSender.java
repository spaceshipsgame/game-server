package spaceships.gameserver.server;

public class NotificationSender {

	private NotificationQueue notificationQueue;

	public NotificationSender(NotificationQueue notificationQueue) {
		this.notificationQueue = notificationQueue;
	}

	public void sendNotifications() {
		while (!notificationQueue.isEmpty()) {
			notificationQueue.poll().send();
		}
	}

}
