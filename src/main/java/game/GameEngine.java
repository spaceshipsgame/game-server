package game;

import game.events.Event;

public class GameEngine {

    private NotificationQueue notificationQueue;

    public GameEngine(NotificationQueue notificationQueue) {
        this.notificationQueue = notificationQueue;
    }

    public void proccess(Event event){

    }
}
