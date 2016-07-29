package spaceships.gameserver.server;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spaceships.gameserver.model.Match;
import spaceships.gameserver.model.server.Player;

import java.util.Hashtable;

@Component
public class WaitMatchManagerImpl implements WaitMatchManager {

    private static Logger logger = Logger.getLogger(WaitMatchManagerImpl.class);

    private Hashtable<String, MatchManager> hashMatchDictionary = new Hashtable<>();

    @Override
    public Player findPlayer(String playerHash) {
        MatchManager matchManager = hashMatchDictionary.get(playerHash);
        if(matchManager != null){
            return findPlayerInMatch(playerHash, matchManager.getMatch());
        }
        return null;
    }

    @Override
    public void addNewMatch(Match match) {
        MatchManager matchManager = new MatchManager(match);
        for(Player player : match.getTeam1().getPlayers()){
            hashMatchDictionary.put(player.getPlayerHash(), matchManager);
        }
        for(Player player : match.getTeam2().getPlayers()){
            hashMatchDictionary.put(player.getPlayerHash(), matchManager);
        }
    }

    @Override
    public MatchManager getMatchManager(String playerHash) {
        return hashMatchDictionary.get(playerHash);
    }

    private Player findPlayerInMatch(String playerHash, Match match){
        for(Player player : match.getTeam1().getPlayers()){
            if(checkPlayer(playerHash, player, match)) return player;
        }
        for(Player player : match.getTeam2().getPlayers()){
            if(checkPlayer(playerHash, player, match)) return player;
        }
        return null;
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
