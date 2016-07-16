package spaceships.gameserver.server;

import spaceships.gameserver.model.Connection;
import spaceships.gameserver.model.Player;

public interface ConnectionResolver {

    public Player attachToPlayer(Connection connection, String playerHash);
}
