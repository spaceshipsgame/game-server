package spaceships.gameserver.server;

import spaceships.gameserver.engine.PlayerActionHandler;
import spaceships.gameserver.engine.PlayerActionHandlerChainFactory;
import spaceships.gameserver.engine.PlayerActionQueue;
import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.action.PlayerAction;

import java.util.ArrayList;
import java.util.List;

public class PlayerActionProcessorImpl implements PlayerActionProcessor {

	private PlayerActionHandler chain;

	public PlayerActionProcessorImpl() {
		PlayerActionHandlerChainFactory chainFactory = new PlayerActionHandlerChainFactory();
		chain = chainFactory.createChain();
	}

	@Override
	public List<Event> processActions(PlayerActionQueue actionQueue) {
		List<Event> events = new ArrayList<>();
		while (actionQueue.isEmpty()) {
			events.addAll(chain.handle(actionQueue.poll()));
		}
		return events;
	}

}
