package spaceships.gameserver.server;

import spaceships.gameserver.model.Match;
import spaceships.gameserver.model.Player;

public interface WaitMatchManager{

    public Player findPlayer(String playerHash);

    public void addNewMatch(Match match);
}
