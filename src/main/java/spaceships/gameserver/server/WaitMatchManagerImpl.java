package spaceships.gameserver.server;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spaceships.gameserver.model.Match;
import spaceships.gameserver.model.Player;

import java.util.ArrayList;
import java.util.List;

@Component
public class WaitMatchManagerImpl implements WaitMatchManager {

    private static Logger logger = Logger.getLogger(WaitMatchManagerImpl.class);

    private List<Match> waitMatches = new ArrayList<Match>();

    @Override
    public Player findPlayer(String playerHash) {
        for(Match match : waitMatches){
            for(Player player : match.getTeam1().getPlayers()){
                if(checkPlayer(playerHash, player, match)) return player;
            }
            for(Player player : match.getTeam2().getPlayers()){
                if(checkPlayer(playerHash, player, match)) return player;
            }
        }
        return null;
    }

    @Override
    public void addNewMatch(Match match) {
        waitMatches.add(match);
        MatchManager matchManager = new MatchManager(match);
        matchManager.startMatch();
    }

    private boolean checkPlayer(String playerHash, Player player, Match match){
        if(playerHash.equals(player.getPlayerHash())){
            match.connectToGame(player);
            logger.info("Player with hash: " + playerHash + "connect to the match with hash: " + match.hashCode());
            return true;
        }
        logger.warn("No match with player that have hash: " + playerHash);
        return false;
    }
}
