package protocol;

public abstract class PlayerActionHandler {

	private PlayerActionHandler successor;

	public PlayerActionHandler() {
	}

	public PlayerActionHandler(PlayerActionHandler successor) {
		this.successor = successor;
	}

	public void handle(PlayerAction action) {
		if (successor != null) {
			successor.handle(action);
		}
	}

	public void setSuccessor(PlayerActionHandler successor) {
		this.successor = successor;
	}
}