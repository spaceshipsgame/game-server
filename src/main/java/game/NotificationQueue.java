package game;


import game.events.Event;
import protocol.notification.Notification;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isEmpty(){
        return buffer.isEmpty();
    }
}
