package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;

public class ReverseRocket extends Rocket {

    static final float THRUST = -50000000;
    static final float ENERGY_CONSUMPTION = 1;

    static final float WIDTH = 5F;
    static final float HEIGHT = 3F;
    static final float CORNER_DISTANCE = (float) Math.sqrt(WIDTH * WIDTH + HEIGHT * HEIGHT);

    static final PolygonDef shape = new PolygonDef();

    public ReverseRocket(BodyDef bd, char activationKey) {
        super(new PolygonDef(), bd, THRUST, activationKey);
    }

    @Override
    public void init() {
        updateShape(WIDTH, HEIGHT);
        setShapeProperties(0, 8, 0);
    }

    @Override
    public float update(float deltaTime) {
        if (active) {
            float bodyAngle = BODY.getAngle();
            Vec2 forceVector = new Vec2((float) (Math.cos(bodyAngle) * THRUST * deltaTime), (float) (Math.sin(bodyAngle) * THRUST * deltaTime));
            BODY.applyForce(forceVector, BODY.getWorldCenter());
            return ENERGY_CONSUMPTION * deltaTime;
        }
        return 0;
    }

    @Override
    public void controls(HashSet<Character> controls) {
        active = controls.contains(ACT_KEY);
    }

}
