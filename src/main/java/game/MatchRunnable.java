package game;

import protocol.PlayerActionHandler;
import protocol.PlayerActionQueue;

public class MatchRunnable implements Runnable {

    private GameEngine gameEngine;
    private PlayerActionQueue playerActionQueue;
    private PlayerActionHandler chain;
    private EventQueue eventQueue;
    private NotificationQueue notificationQueue;
    private PlayerActionProcessor playerActionProcessor;


    @Override
    public void run() {
        while(!playerActionQueue.isEmpty()){
            chain.handle(playerActionQueue.poll());
        }
        while(!playerActionQueue.isEmpty()){
            gameEngine.proccess(eventQueue.poll());
        }
    }
}
