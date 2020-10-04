package celestialwars.server.ships.parts;

import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.BodyDef;

public abstract class Core extends Part {

    final float ENERGY_PER_SEC;

    public Core(PolygonDef shape, BodyDef bd, float energyPerSec) {
        super(shape, bd);
        ENERGY_PER_SEC = energyPerSec;
    }
}
