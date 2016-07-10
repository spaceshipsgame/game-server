package game;

import model.Connection;
import model.Player;

public class ConnectionResolverImpl implements ConnectionResolver {

	private WaitMatchManager waitMatchManager;
	private ConnectionResolver failedConnectionPlayerPool;

	@Override
	public Player attachToPlayer(Connection connection, String playerHash) {
		Player player = waitMatchManager.findPlayer(playerHash);
		if (player != null) {
			player.setConnection(connection);
			return player;
		}
		player = failedConnectionPlayerPool.attachToPlayer(connection, playerHash);
		if (player != null) {
			player.setConnection(connection);
		}
		return player;
	}
}
