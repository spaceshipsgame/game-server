package spaceships.gameserver.physic;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import spaceships.gameserver.model.Gun;
import spaceships.gameserver.model.Ship;

import java.util.HashMap;
import java.util.Map;


public class PhysicEngineImpl implements PhysicEngine {

    private float deltaTimeSimulation;
    private int velocityIterationCount; //default value in testbed 8
    private int positionIterationCount; //default value in testbed 3

    private World world;
    private Map<Ship, ShipBody> bindingMap = new HashMap<>();

    public PhysicEngineImpl(float deltaTimeSimulation, int velocityIterationCount, int positionIterationCount) {
        this.deltaTimeSimulation = deltaTimeSimulation;
        this.velocityIterationCount = velocityIterationCount;
        this.positionIterationCount = positionIterationCount;
    }

    @Override
    public void init() {
        world = new World(new Vec2(0.0f, -0.0f));

    }

    @Override
    public void addNewShip(Ship ship, float x , float y, float weight, float height) {
        ShipBody shipBody = new ShipBody(world, ship, x, y, weight, height);
        bindingMap.put(ship, shipBody);
    }

    @Override
    public void accelerate(Ship ship) {
        bindingMap.get(ship).accelerate();
    }

    @Override
    public void stopAccelerate(Ship ship) {
        bindingMap.get(ship).stopAccelerate();
    }

    @Override
    public void turnLeft(Ship ship, float angleChangingIntensity) {
        bindingMap.get(ship).turnLeft(angleChangingIntensity);
    }

    @Override
    public void turnRight(Ship ship, float angleChangingIntensity) {
        bindingMap.get(ship).turnRight(angleChangingIntensity);
    }

    @Override
    public void stopTurning(Ship ship) {
        bindingMap.get(ship).stopTurn();
    }


    @Override
    public void shoot(Gun gun) {

    }

    @Override
    public void shoot(Ship ship, Gun gun) {

    }

    @Override
    public void doStep() {
        for(ShipBody shipBody : bindingMap.values()){
            shipBody.onStep(deltaTimeSimulation);
        }
        world.step(deltaTimeSimulation, velocityIterationCount, positionIterationCount);
    }
}
