package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.BodyDef;

public class BasicCore extends Core {

    final static float WIDTH = 25;
    final static float HEIGHT = 25;
    final static float ENERGY_PRODUCTION = 5;
    static final float CORNER_DISTANCE = (float) Math.sqrt(WIDTH * WIDTH + HEIGHT * HEIGHT);

    public BasicCore(BodyDef bd) {
        super(new PolygonDef(), bd, ENERGY_PRODUCTION);
    }

    @Override
    public void init() {
        updateShape(WIDTH, HEIGHT);
        setShapeProperties(0, 8, 0);
    }

    @Override
    public float update(float deltaTime) {
        return -ENERGY_PRODUCTION * deltaTime;
    }

    @Override
    public void controls(HashSet<Character> controls) {

    }

}
