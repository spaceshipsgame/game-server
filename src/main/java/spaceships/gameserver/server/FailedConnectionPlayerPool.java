package spaceships.gameserver.server;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import spaceships.gameserver.model.server.Player;

import java.util.Map;

@Component
public class FailedConnectionPlayerPool{

    private static Logger logger = Logger.getLogger(FailedConnectionPlayerPool.class);
    //should be thread safe collection
    private Map<String, Player> failedConnectionPlayers;


    public void addPlayer(Player player){
        failedConnectionPlayers.put(player.getPlayerHash(), player);
    }

    public Player findPlayer(String playerHash) {
        Player player = failedConnectionPlayers.get(playerHash);
        if(player == null){
            logger.debug("Player is not presented in pool");
        } else {
            logger.debug("Player is find in pool");
        }
        return player;
    }
}
