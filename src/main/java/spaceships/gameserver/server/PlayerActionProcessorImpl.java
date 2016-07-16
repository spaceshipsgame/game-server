package spaceships.gameserver.server;

import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionQueue;

public class PlayerActionProcessorImpl implements PlayerActionProcessor {

	private PlayerActionQueue playerActionQueue;
	private PlayerActionHandler chain;

	public PlayerActionProcessorImpl(PlayerActionQueue playerActionQueue, PlayerActionHandler chain) {
		this.playerActionQueue = playerActionQueue;
		this.chain = chain;
	}

	@Override
	public void processActions() {
		while (!playerActionQueue.isEmpty()) {
			chain.handle(playerActionQueue.poll());
		}
	}

}
