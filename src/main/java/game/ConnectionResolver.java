package game;

import model.Connection;
import model.Player;

public interface ConnectionResolver {

    public Player attachToPlayer(Connection connection, String playerHash);
}
