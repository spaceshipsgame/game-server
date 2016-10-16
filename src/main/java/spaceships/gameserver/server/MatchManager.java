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
    private GameTickTask tickTask;

    public MatchManager(Match match) {
        this.match = match;
        this.tickTask = new GameTickTask();
        worker = new Timer();
    }

    public void startMatch(){
        worker.schedule(tickTask, 0, GAME_TICK_MILLIS);
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public GameTickTask getTickTask() {
        return tickTask;
    }

    public void setTickTask(GameTickTask tickTask) {
        this.tickTask = tickTask;
    }
}
