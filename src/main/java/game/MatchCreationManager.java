package game;

import model.Match;

public interface MatchCreationManager {

    public boolean connectToMatch(String playerHash);

    public void addNewMatch(Match match);
}
