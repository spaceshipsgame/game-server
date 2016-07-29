package spaceships.gameserver.server;

import spaceships.gameserver.model.Match;
import spaceships.gameserver.model.server.Player;

public interface WaitMatchManager{

    Player findPlayer(String playerHash);

    void addNewMatch(Match match);

    MatchManager getMatchManager(String playerHash);
}
