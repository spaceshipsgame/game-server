package spaceships.gameserver.engine;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import spaceships.gameserver.server.protocol.action.PlayerAction;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerActionQueue {

	private Queue<PlayerAction> buffer;

	public PlayerActionQueue() {
		buffer = new LinkedList<>();
	}

	public boolean offer(PlayerAction e) {
		return buffer.offer(e);
	}

	public PlayerAction poll() {
		return buffer.poll();
	}

	public boolean isEmpty(){
		return buffer.isEmpty();
	}
}
