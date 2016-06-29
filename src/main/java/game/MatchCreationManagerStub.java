package game;

import model.Match;
import org.apache.log4j.Logger;

import java.util.List;

public class MatchCreationManagerStub implements MatchCreationManager{

    private static Logger logger = Logger.getLogger(MatchCreationManagerStub.class);

    private final static String HARDCODED_HASH = "HARDCODED_HASH";
    private final static Match HARDCODED_MATCH = new Match();

    public MatchCreationManagerStub() {}

    @Override
    public boolean connectToMatch(String playerHash) {
        if(playerHash == HARDCODED_HASH){
            //use some service that run match
            logger.info("Player with hash: " + playerHash + "connect to the match with hash1: " + HARDCODED_MATCH.hashCode());
            return true;
        }
        logger.warn("No match with player tha have hash: " + playerHash);
        return false;
    }

    @Override
    public void addNewMatch(Match match) {

    }
}
