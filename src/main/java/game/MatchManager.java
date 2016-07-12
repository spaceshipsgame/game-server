package game;

import model.Match;

public class MatchManager {

    private Match match;
    private GameEngine gameEngine;
    private Thread worker;
    private MatchRunnable runnable;

    public MatchManager(Match match) {
        this.match = match;
        NotificationQueue notificationQueue = new NotificationQueue();
        gameEngine = new GameEngine(notificationQueue);
        this.runnable = new MatchRunnable();
        worker = new Thread(this.runnable);
    }

    public void startMatch(){
        worker.start();
    }
}
