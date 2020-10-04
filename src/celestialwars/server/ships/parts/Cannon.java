package celestialwars.server.ships.parts;

import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.BodyDef;

public abstract class Cannon extends Part {
    
    final char ACT_KEY;
    final float TIME_TO_SHOOT;
    float coolDownCounter = 0;
    
    boolean active = false;

    public Cannon(PolygonDef shape, BodyDef bd, float timeToShoot, char activationKey) {
        super(shape, bd);
        TIME_TO_SHOOT = timeToShoot;
        ACT_KEY = activationKey;
    }
    
}
