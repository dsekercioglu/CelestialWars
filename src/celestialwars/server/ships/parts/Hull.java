package celestialwars.server.ships.parts;

import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;

public abstract class Hull extends Part {

    public Hull(PolygonDef shape, BodyDef bd) {
        super(shape, bd);
    }

}
