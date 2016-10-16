package spaceships.gameserver.physic.testbed;

import com.sun.xml.internal.bind.v2.TODO;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.testbed.framework.TestbedSettings;
import org.jbox2d.testbed.framework.TestbedTest;
import spaceships.gameserver.physic.Box2dUtils;

// doc for testbed: https://github.com/jbox2d/jbox2d/wiki/Testbed
public class GameTestbedModel extends TestbedTest {

    Body body;
    Vec2 direction;
    boolean isWPressed = false;
    float maxSpeed = 100f;

    @Override
    public void initTest(boolean deserialized) {
        setTitle("Couple of Things Test");

        getWorld().setGravity(new Vec2());

        World world = getWorld();
        Box2dUtils.createBorders(world, 0, 1000, 0, 2000);
        body = Box2dUtils.createDynamicBox(world, new Vec2(50, 50), 2, 5);
        direction = new Vec2(0, 1);
//        body.setLinearVelocity(new Vec2(0, 20));
    }

    @Override
    public String getTestName() {
        return "Spaceships Game Model";
    }

//    @Override
//    public void mouseMove(Vec2 p) {
//        super.mouseMove(p);
//        System.out.println(p.x + " " + p.y);
//    }


    @Override
    public void keyReleased(char keyChar, int keyCode) {
        super.keyReleased(keyChar, keyCode);
        switch (keyChar){
            case 'w':
                isWPressed = false;
                break;
            case 'd':
                body.setAngularVelocity(0);
                break;
            case 'a':
                body.setAngularVelocity(0);
                break;
        }
    }

    @Override
    public void keyPressed(char keyChar, int keyCode) {
        super.keyPressed(keyChar, keyCode);
//        System.out.println(keyChar + " " + keyCode);
        switch (keyChar){
            case 'w':
                isWPressed = true;
                break;
            case 'd':
                body.setAngularVelocity(-4);
                break;
            case 'a':
                body.setAngularVelocity(4);
                break;
            case 'p':
                System.out.println(body.getLinearVelocity());
                break;
        }
    }

    @Override
    public synchronized void step(TestbedSettings settings) {
        if(isWPressed) {
            changeSpeed(body, 5000, Box2dUtils.calculateDirection(body.getAngle()), maxSpeed);
        }
        System.out.println(body.getLinearVelocity() + " " + body.getLinearVelocity().length());
        super.step(settings);
    }

    public void changeSpeed(Body body, float speedDelta, Vec2 direction, float maxSpeed){

//        TODO: this code not works correct because code in if statement remove acceleration over max speed only in previous
//        TODO: step, but applyForce in first line make acceleration over max speed again.
        body.applyForceToCenter(direction.mul(speedDelta));
//        http://www.iforce2d.net/b2dtut/constant-speed
        if (body.getLinearVelocity().length() > maxSpeed) {
//            apply contr force to exclude acceleration over max speed that comes when force from input will applied
            float velocityDelta = maxSpeed - body.getLinearVelocity().length();
            float force = body.getMass() * velocityDelta / (1 / 60.0f);
            Vec2 forceVecor = body.getLinearVelocity().clone();
            forceVecor.normalize();
            forceVecor.mulLocal(force);
            body.applyForceToCenter(forceVecor);
        }
    }
}
