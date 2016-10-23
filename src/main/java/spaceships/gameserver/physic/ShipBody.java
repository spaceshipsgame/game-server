package spaceships.gameserver.physic;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import spaceships.gameserver.model.Player;

public class ShipBody{

    private Player ship;
    private Body body;
    private boolean acceleration;

    public ShipBody(World world, Player player, float x , float y, float weight, float height) {
        this.ship = player;
        this.body = Box2dUtils.createDynamicBox(world, new Vec2(x, y), weight, height);
    }

    public void accelerate(){
        acceleration = true;
    }

    public void stopAccelerate(){
        acceleration = false;
    }

    public void turnLeft(float angleChangingIntensity){
        body.setAngularVelocity(angleChangingIntensity);
    }

    public void turnRight(float angleChangingIntensity){
        body.setAngularVelocity(-angleChangingIntensity);
    }

    public void stopTurn(){
        body.setAngularVelocity(0);
    }

    public void onStep(float deltaTime){
        if(acceleration) {
            Vec2 direction = Box2dUtils.calculateDirection(body.getAngle());
            body.applyForceToCenter(direction.mul(ship.getAcceleration()));
//            if (body.getLinearVelocity().length() > player.getMaxSpeed()) {
//                body.getLinearVelocity().normalize();
//                body.setLinearVelocity(body.getLinearVelocity().mul(player.getMaxSpeed()));
//            }

//            http://www.iforce2d.net/b2dtut/constant-speed
            if (body.getLinearVelocity().length() > ship.getMaxSpeed()) {
//            apply contr force to exclude acceleration over max speed that comes when force from input will applied
                float velocityDelta = ship.getMaxSpeed() - body.getLinearVelocity().length();
                float force = body.getMass() * velocityDelta / (deltaTime);
                Vec2 forceVecor = body.getLinearVelocity().clone();
                forceVecor.normalize();
                forceVecor.mulLocal(force);
                body.applyForceToCenter(forceVecor);
            }
        }
    }
}
