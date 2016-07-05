package game;

import model.Connection;
import model.Player;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class FailedConnectionPlayerPool implements ConnectionResolver{

    private static Logger logger = Logger.getLogger(FailedConnectionPlayerPool.class);
    //should be thread safe collection
    HashMap<String, Player> failedConnectionPlayers;


    public void addPlayer(Player player){
        failedConnectionPlayers.put(player.getPlayerHash(), player);
    }

    @Override
    public Player attachToPlayer(Connection connection, String playerHash) {
        Player player = failedConnectionPlayers.get(playerHash);
        if(player == null){
            logger.debug("Player is not presented in pool");
        } else {
            player.setConnection(connection);
            logger.debug("Player is find in pool");
        }
        return player;
    }
}
