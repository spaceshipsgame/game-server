package spaceships.gameserver.engine;

import spaceships.gameserver.engine.event.Event;
import spaceships.gameserver.server.protocol.action.PlayerAction;

import java.util.List;

public abstract class PlayerActionHandler {

	private PlayerActionHandler successor;

	public PlayerActionHandler() {
	}

	public PlayerActionHandler(PlayerActionHandler successor) {
		this.successor = successor;
	}

	public List<Event> handle(PlayerAction action) {
//		TODO: implement real action handling
		if (successor != null) {
			successor.handle(action);
		}
		return null;
	}

	public void setSuccessor(PlayerActionHandler successor) {
		this.successor = successor;
	}
}
