package spaceships.gameserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.model.server.Player;

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
			PlayerActionQueue queue = waitMatchManager.getMatchManager(playerHash).getTickTask().getPlayerActionQueue();
			connection.setActionQueue(queue);
			player.setConnection(connection);
			return player;
		}
		player = failedConnectionPlayerPool.findPlayer(playerHash);
		if (player != null) {
			connection.setActionQueue(player.getConnection().getActionQueue());
			player.setConnection(connection);
		}
		return player;
	}
}
