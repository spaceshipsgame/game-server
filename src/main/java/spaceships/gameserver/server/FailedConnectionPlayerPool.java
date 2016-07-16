package spaceships.gameserver.server;

import org.apache.log4j.Logger;

import spaceships.gameserver.model.Connection;
import spaceships.gameserver.model.Player;

import java.util.Map;

public class FailedConnectionPlayerPool implements ConnectionResolver{

    private static Logger logger = Logger.getLogger(FailedConnectionPlayerPool.class);
    //should be thread safe collection
    private Map<String, Player> failedConnectionPlayers;


    public void addPlayer(Player player){
        failedConnectionPlayers.put(player.getPlayerHash(), player);
    }

    @Override
    public Player attachToPlayer(Connection connection, String playerHash) {
        Player player = failedConnectionPlayers.get(playerHash);
        if(player == null){
            logger.debug("Player is not presented in pool");
        } else {
            logger.debug("Player is find in pool");
        }
        return player;
    }
}
