package game;

import protocol.PlayerActionHandler;
import protocol.PlayerActionQueue;

public class MatchWorker implements Runnable {

    private GameEngine gameEngine;
    private PlayerActionQueue playerActionQueue;
    private PlayerActionHandler chain;
    private EventQueue eventQueue;

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
