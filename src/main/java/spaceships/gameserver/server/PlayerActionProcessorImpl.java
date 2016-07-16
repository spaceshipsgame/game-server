package spaceships.gameserver.server;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionQueue;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerActionProcessorImpl implements PlayerActionProcessor {

	private PlayerActionQueue playerActionQueue;
	private PlayerActionHandler chain;

	public PlayerActionProcessorImpl() {
		// TODO Auto-generated constructor stub
	}
	
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
