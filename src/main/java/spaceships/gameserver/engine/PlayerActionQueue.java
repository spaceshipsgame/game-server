package spaceships.gameserver.engine;

import java.util.LinkedList;
import java.util.Queue;

import spaceships.gameserver.server.protocol.action.PlayerAction;

//TODO:make this class thread-safe
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
