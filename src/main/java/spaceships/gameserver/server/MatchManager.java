package spaceships.gameserver.server;

import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.model.Match;

public class MatchManager {

    private Match match;
    private GameEngine gameEngine;
    private Thread worker;
    private MatchRunnable runnable;

    public MatchManager(Match match) {
        this.match = match;
//        NotificationQueue notificationQueue = new NotificationQueue();
//        gameEngine = new GameEngine(notificationQueue);
//        this.runnable = new MatchRunnable();
//        worker = new Thread(this.runnable);
    }

    public void startMatch(){
        worker.start();
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public MatchRunnable getRunnable() {
        return runnable;
    }

    public void setRunnable(MatchRunnable runnable) {
        this.runnable = runnable;
    }
}
