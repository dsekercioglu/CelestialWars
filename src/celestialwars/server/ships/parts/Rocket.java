package celestialwars.server.ships.parts;

import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public abstract class Rocket extends Part {

    final char ACT_KEY;
    
    boolean active = false;

    public Rocket(PolygonDef shape, BodyDef bd, float thrust, char activationKey) {
        super(shape, bd);
        ACT_KEY = activationKey;

    }

}
