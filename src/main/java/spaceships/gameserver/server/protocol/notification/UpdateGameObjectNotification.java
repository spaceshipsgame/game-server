package spaceships.gameserver.server.protocol.notification;

import spaceships.gameserver.model.output.MovingObject;

public class UpdateGameObjectNotification implements Notification{

	private MovingObject movingObject;

	public MovingObject getMovingObject() {
		return movingObject;
	}

	public void setMovingObject(MovingObject movingObject) {
		this.movingObject = movingObject;
	}

	@Override
	public void send() {
		// TODO Auto-generated method stub
		
	}
}
