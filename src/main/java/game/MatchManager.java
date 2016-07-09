package game;

import model.Match;

public class MatchManager {

    private Match match;
    private GameEngine gameEngine;
    private Thread worker;

    public MatchManager(Match match) {
        this.match = match;
        worker = new Thread(new MatchRunnable());
    }

    public void startMatch(){
        worker.start();
    }
}
