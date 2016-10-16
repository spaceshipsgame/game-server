package spaceships.gameserver.physic;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Box2dUtils {

    public static void createBorders(World world, float xFrom, float xTo, float yFrom, float yTo){

        BodyDef bd = new BodyDef();
        bd.position.set(0.0f, 20.0f);
        Body ground = world.createBody(bd);

        EdgeShape shape = new EdgeShape();

        FixtureDef sd = new FixtureDef();
        sd.shape = shape;

        // Left vertical
        shape.set(new Vec2(xFrom, yFrom), new Vec2(xFrom, yTo));
        ground.createFixture(sd);

        // Right vertical
        shape.set(new Vec2(xTo, yFrom), new Vec2(xTo, yTo));
        ground.createFixture(sd);

        // Top horizontal
        shape.set(new Vec2(xFrom, yTo), new Vec2(xTo, yTo));
        ground.createFixture(sd);

        // Bottom horizontal
        shape.set(new Vec2(xFrom, yFrom), new Vec2(xTo, yFrom));
        ground.createFixture(sd);
    }

    public static Body createDynamicBox(World world, Vec2 position, float weight, float height){
        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.linearDamping = 0.3f;
        bd.position.set(position);
        Body body = world.createBody(bd);
        
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(weight, height);

        FixtureDef fd = new FixtureDef();
        fd.shape = shape;
        fd.density = 1.0f;

        body.createFixture(fd);

        return body;
    }

    public static Vec2 calculateDirection(float angle){
        float y = (float) Math.cos(angle);
        float x = (float) Math.sin(angle);
        return new Vec2(-x, y);
    }

}
