package game.playersaction;

import java.util.LinkedList;
import java.util.Queue;

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

}
