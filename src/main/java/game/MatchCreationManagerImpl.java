package game;

import model.Match;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class MatchCreationManagerImpl implements MatchCreationManager{

    private List<Match> waitMatches = new ArrayList<Match>();

    @Override
    public boolean connectToMatch(String playerHash) {
        for(Match match : waitMatches){
            for(Player player : match.getTeam1().getPlayers()){
                if(checkPlayer(playerHash, player, match)) return true;
            }
            for(Player player : match.getTeam2().getPlayers()){
                if(checkPlayer(playerHash, player, match)) return true;
            }
        }
        return false;
    }

    @Override
    public void addNewMatch(Match match) {
        waitMatches.add(match);
    }

    public boolean checkPlayer(String playerHash, Player player, Match match){
        if(playerHash == player.getPlayerHash()){
            match.connectToGame(player);
            return true;
        }
        return false;
    }
}
