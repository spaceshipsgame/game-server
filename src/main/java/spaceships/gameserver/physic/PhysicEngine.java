package spaceships.gameserver.physic;

import spaceships.gameserver.model.Gun;
import spaceships.gameserver.model.Ship;

public interface PhysicEngine {

    void init();

    void addNewShip(Ship ship, float x , float y, float weight, float height);

    void accelerate(Ship ship);

    void stopAccelerate(Ship ship);

    void turnLeft(Ship ship, float angleChangingIntensity);

    void turnRight(Ship ship, float angleChangingIntensity);

    void stopTurning(Ship ship);

    void shoot(Gun gun);

    void shoot(Ship ship, Gun gun);

    void doStep();

}
