package spaceships.gameserver.server;

import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.model.server.Player;

public interface ConnectionResolver {

    public Player attachToPlayer(Connection connection, String playerHash);
}
