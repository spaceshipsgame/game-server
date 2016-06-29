package game.playersaction;

public abstract class PlayersActionHandler {

	private PlayersActionHandler successor;

	public PlayersActionHandler() {
	}

	public PlayersActionHandler(PlayersActionHandler successor) {
		this.successor = successor;
	}

	public void handle(PlayersAction action) {
		if (successor != null) {
			successor.handle(action);
		}
	}

}
