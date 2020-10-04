package celestialwars.server.ships.parts;

import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;

public class TriangleHull extends Part {

    final int WIDTH = 5;
    final int HEIGHT = 5;
    final Vec2[] VERTICES;
    final float ANGLE;

    public TriangleHull(BodyDef bd, float angle) {
        super(new PolygonDef(), bd);
        ANGLE = angle;
        VERTICES = new Vec2[3];
    }

    @Override
    public void init() {
        float angleDegrees = (float) Math.toDegrees(ANGLE);
        while (angleDegrees < 0) {
            angleDegrees += 360;
        }
        angleDegrees %= 360;
        float sx = angleDegrees % 270 < 45 ? 0 : 1;
        float sy = angleDegrees < 135 ? 0 : 1;
        VERTICES[0] = new Vec2(sx * WIDTH - WIDTH / 2, sy * HEIGHT - HEIGHT / 2);
        sx = (sx + 1) % 2;
        sy = (sy + 1) % 2;
        VERTICES[1] = new Vec2(sx * WIDTH - WIDTH / 2, sy * HEIGHT - HEIGHT / 2);
        VERTICES[2] = new Vec2((sy + 1) % 2 * WIDTH - WIDTH / 2, sx * HEIGHT - HEIGHT / 2);
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
