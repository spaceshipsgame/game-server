package spaceships.gameserver.engine.event;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import spaceships.gameserver.model.Ship;

import java.util.Map;

public class MoveShipEvent implements Event {

    private Ship ship;
    private MoveType type;
    private int power;

    public MoveShipEvent(Ship ship, MoveType type, int power) {
        this.ship = ship;
        this.type = type;
        this.power = power;
    }

    @Override
    public void execute() {
    }

    public enum MoveType {
        LEFT, RIGHT, ACCELERATE, SLOW_DOWN
    }
}
