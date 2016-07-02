package game;

import model.Match;

public interface WaitMatchManager {

    public boolean connectToMatch(String playerHash);

    public void addNewMatch(Match match);
}
