package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public abstract class Part {

    
    final static int TILE_WIDTH = 5;
    final PolygonDef SHAPE;
    final BodyDef BODY_DEF;
    Body BODY;

    boolean destroyed = false;

    public Part(PolygonDef shape, BodyDef bodyDef) {
        SHAPE = shape;
        BODY_DEF = bodyDef;
    }

    public abstract void init();

    public void createBody(World world) {
        BODY = world.createBody(BODY_DEF);
        BODY.createShape(SHAPE);
        BODY.m_type = 1;
        BODY.wakeUp();
        BODY.setMassFromShapes();
    }

    public void setShapeProperties(float friction, float density, float restitution) {
        SHAPE.friction = friction;
        SHAPE.density = density;
        SHAPE.restitution = restitution;
    }

    public void updateShape(Vec2[] vertices) {
        for (int i = 0; i < vertices.length; i++) {
            SHAPE.addVertex(vertices[i]);
        }
    }

    public void updateShape(float width, float height) {
        SHAPE.setAsBox(width / 2, height / 2);
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
    
    public PolygonDef getShape() {
        return SHAPE;
    }
   
    /**
     *
     * @param deltaTime Time in seconds
     * @return Energy Consumed
     */
    public abstract float update(float deltaTime);

    public abstract void controls(HashSet<Character> controls);
}
