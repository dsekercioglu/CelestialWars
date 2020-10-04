package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.BodyDef;

public class BasicHull extends Hull {

    static final float WIDTH = 5;
    static final float HEIGHT = 5;
    static final float CORNER_DISTANCE = (float) Math.sqrt(WIDTH * WIDTH + HEIGHT * HEIGHT);

    public BasicHull(BodyDef bd) {
        super(new PolygonDef(), bd);
    }

    @Override
    public void init() {
        updateShape(WIDTH, HEIGHT);
        setShapeProperties(0, 8, 0);
    }

    @Override
    public float update(float deltaTime) {
        return 0;
    }

    @Override
    public void controls(HashSet<Character> controls) {

    }

}
