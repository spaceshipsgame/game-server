package game;

import model.Match;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class WaitMatchManagerImpl implements WaitMatchManager {

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
    }

    public boolean checkPlayer(String playerHash, Player player, Match match){
        if(playerHash.equals(player.getPlayerHash())){
            match.connectToGame(player);
            return true;
        }
        return false;
    }
}