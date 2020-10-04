package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;

public class PolygonHull extends Hull {

    final Vec2[] VERTICES;

    public PolygonHull(Vec2[] vectors, BodyDef bd) {
        super(new PolygonDef(), bd);
        VERTICES = vectors;
    }

    @Override
    public void init() {
        updateShape(VERTICES);
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
