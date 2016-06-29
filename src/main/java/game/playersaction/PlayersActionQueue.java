package game.playersaction;

import java.util.LinkedList;
import java.util.Queue;

public class PlayersActionQueue {

	private Queue<PlayersAction> queue;

	public PlayersActionQueue() {
		queue = new LinkedList<>();
	}

	public boolean offer(PlayersAction e) {
		return queue.offer(e);
	}

	public PlayersAction poll() {
		return queue.poll();
	}

}
