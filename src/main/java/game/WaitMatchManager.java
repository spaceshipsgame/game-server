package game;

import model.Match;
import model.Player;

public interface WaitMatchManager{

    public Player findPlayer(String playerHash);

    public void addNewMatch(Match match);
}
