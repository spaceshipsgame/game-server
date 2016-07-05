package game;

import model.Match;
import model.Player;
import org.apache.log4j.Logger;

public class WaitMatchManagerStub implements WaitMatchManager {

    private static Logger logger = Logger.getLogger(WaitMatchManagerStub.class);

    private final static String HARDCODED_HASH = "HARDCODED_HASH";
    private final static Match HARDCODED_MATCH = new Match();

    public WaitMatchManagerStub() {}

    @Override
    public Player resolveConnection(String playerHash) {
        if(playerHash == HARDCODED_HASH){
            //use some service that run match
            logger.info("Player with hash: " + playerHash + "connect to the match with hash1: " + HARDCODED_MATCH.hashCode());
            return new Player();
        }
        logger.warn("No match with player tha have hash: " + playerHash);
        return null;
    }

    @Override
    public void addNewMatch(Match match) {

    }
}
