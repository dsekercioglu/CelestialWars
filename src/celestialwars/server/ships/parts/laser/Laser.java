package celestialwars.server.ships.parts.laser;

import celestialwars.server.env.Environment;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class Laser {

    final float RADIUS;
    Body BODY;
    final BodyDef BODY_DEF;
    final CircleDef SHAPE;
    final float FORCE;

    public Laser(float radius, Vec2 startLocation, float force, float angle) {
        RADIUS = radius;
        SHAPE = new CircleDef();
        SHAPE.radius = RADIUS;
        SHAPE.density = 8;
        SHAPE.friction = 0;
        SHAPE.restitution = 0;
        BODY_DEF = new BodyDef();
        BODY_DEF.position.set(startLocation);
        BODY_DEF.isBullet = true;
        BODY_DEF.angle = angle;
        FORCE = force;
    }

    public void createLaser(World world) {
        BODY = world.createBody(BODY_DEF);
        BODY.createShape(SHAPE);
        BODY.m_type = 1;
        BODY.wakeUp();
        BODY.setMassFromShapes();
        Vec2 force = new Vec2((float) (Math.cos(BODY_DEF.angle) * FORCE), (float) (Math.sin(BODY_DEF.angle) * FORCE));
        //BODY.applyForce(BODY.getWorldCenter(), force);
        BODY.setLinearVelocity(force);
    }

    public Vec2 position() {
        return BODY.getPosition();
    }

    public float angle() {
        return BODY.getAngle();
    }

    public Body getBody() {
        return BODY;
    }

    public CircleDef getShape() {
        return SHAPE;
    }

}
