package spaceships.gameserver.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spaceships.gameserver.model.server.Connection;
import spaceships.gameserver.model.server.Player;
import spaceships.gameserver.server.protocol.action.Action;

import java.util.Queue;

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
			Queue<Action> queue = waitMatchManager.getMatchManager(playerHash).getTickTask().getPlayerActionQueue();
			connection.setActions(queue);
			player.setConnection(connection);
			return player;
		}
		player = failedConnectionPlayerPool.findPlayer(playerHash);
		if (player != null) {
			connection.setActions(player.getConnection().getActions());
			player.setConnection(connection);
		}
		return player;
	}
}
