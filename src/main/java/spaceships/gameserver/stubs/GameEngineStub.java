package spaceships.gameserver.stubs;

import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.action.Action;
import spaceships.gameserver.server.protocol.notification.Notification;
import spaceships.gameserver.server.protocol.notification.UpdateGameObjectNotification;

import java.util.List;
import java.util.Queue;

public class GameEngineStub implements GameEngine {
    @Override
    public List<Notification> process(Queue<Action> actions) {
        return null;
    }

//    private EventQueue eventQueue;
//    private NotificationQueue notificationQueue;
//
//    public GameEngineStub(EventQueue eventQueue, NotificationQueue notificationQueue) {
//        this.eventQueue = eventQueue;
//        this.notificationQueue = notificationQueue;
//    }
//
//    private int i = 0;
//    private int GENERATOR_CONST = 60;
//    public void process() {
//        while (!eventQueue.isEmpty()) {
//            eventQueue.poll();
//        }
//        if(i < GENERATOR_CONST){
//            i++;
//        } else {
//            Notification notification = createNotification();
//            //notificationQueue.offer(notification);
//            i = 0;
//        }
//    }
//
//    private Notification createNotification(){
//        Notification notification = new UpdateGameObjectNotification();
//
//        return notification;
//    }
}
