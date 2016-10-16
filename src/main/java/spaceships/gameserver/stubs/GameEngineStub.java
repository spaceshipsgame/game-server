package spaceships.gameserver.stubs;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.server.NotificationQueue;
import spaceships.gameserver.server.protocol.notification.Notification;
import spaceships.gameserver.server.protocol.notification.UpdateGameObjectNotification;

public class GameEngineStub implements GameEngine {

    private EventQueue eventQueue;
    private NotificationQueue notificationQueue;

    public GameEngineStub(EventQueue eventQueue, NotificationQueue notificationQueue) {
        this.eventQueue = eventQueue;
        this.notificationQueue = notificationQueue;
    }

    private int i = 0;
    private int GENERATOR_CONST = 60;
    public void processEvents() {
        while (!eventQueue.isEmpty()) {
            eventQueue.poll();
        }
        if(i < GENERATOR_CONST){
            i++;
        } else {
            Notification notification = createNotification();
            //notificationQueue.offer(notification);
            i = 0;
        }
    }

    private Notification createNotification(){
        Notification notification = new UpdateGameObjectNotification();

        return notification;
    }
}
