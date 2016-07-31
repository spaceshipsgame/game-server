package spaceships.gameserver.server;

import spaceships.gameserver.engine.EventQueue;
import spaceships.gameserver.engine.GameEngine;
import spaceships.gameserver.engine.GameEngineImpl;
import spaceships.gameserver.model.Match;

import java.util.Timer;

public class MatchManager {

    private final static long GAME_TICK_MILLIS = 1000 / 60;

    private Match match;
    private Timer worker;
    private MatchRunnable runnable;

    public MatchManager(Match match) {
        this.match = match;
        NotificationQueue notificationQueue = new NotificationQueue();
        EventQueue eventQueue = new EventQueue();
        GameEngine gameEngine = new GameEngineImpl(eventQueue, notificationQueue);
        this.runnable = new MatchRunnable();
        worker = new Timer();
    }

    public void startMatch(){
        worker.schedule(runnable, 0, GAME_TICK_MILLIS);
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
