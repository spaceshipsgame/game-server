package spaceships.gameserver.physic;

import spaceships.gameserver.model.Gun;
import spaceships.gameserver.model.Player;

public interface PhysicEngine {

    void init();

    void addNewShip(Player ship, float x , float y, float weight, float height);

    void accelerate(Player ship);

    void stopAccelerate(Player ship);

    void turnLeft(Player ship, float angleChangingIntensity);

    void turnRight(Player ship, float angleChangingIntensity);

    void stopTurning(Player ship);

    void shoot(Gun gun);

    void shoot(Player ship, Gun gun);

    void doStep();

}
