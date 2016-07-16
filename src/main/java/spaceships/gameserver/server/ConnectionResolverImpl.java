package spaceships.gameserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spaceships.gameserver.model.Connection;
import spaceships.gameserver.model.Player;

@Component
public class ConnectionResolverImpl implements ConnectionResolver {

	@Autowired
	private WaitMatchManager waitMatchManager;
	
	@Autowired
	private FailedConnectionPlayerPool failedConnectionPlayerPool;

	@Override
	public Player attachToPlayer(Connection connection, String playerHash) {
		Player player = waitMatchManager.findPlayer(playerHash);
		if (player != null) {
			player.setConnection(connection);
			return player;
		}
		player = failedConnectionPlayerPool.findPlayer(connection, playerHash);
		if (player != null) {
			player.setConnection(connection);
		}
		return player;
	}
}
