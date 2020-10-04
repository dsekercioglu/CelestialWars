package celestialwars.server.ships.parts;

import celestialwars.server.env.Environment;
import celestialwars.server.ships.parts.laser.Laser;
import java.util.HashMap;
import java.util.HashSet;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class BasicCannon extends Cannon {
    
    final static float WIDTH = 5;
    final static float HEIGHT = 1;
    final static float FORCE = 100000000;
    
    final Environment ENV;

    public BasicCannon(Environment env, BodyDef bd, char activationKey) {
        super(new PolygonDef(), bd, 0.1F, activationKey);
        ENV = env;
    }

    @Override
    public void init() {
        updateShape(WIDTH, HEIGHT);
        setShapeProperties(0, 4, 0);
        
        HashMap<String, Integer> hm = new HashMap<>();
    }

    @Override
    public float update(float deltaTime) {
        coolDownCounter -= deltaTime;
        coolDownCounter = Math.max(coolDownCounter, 0);
        if(active && coolDownCounter == 0) {
            Vec2 position = BODY.getPosition();
            float angle = BODY.getAngle();
            Vec2 startPosition = new Vec2((float)(position.x + Math.cos(angle) * (WIDTH + 20)), (float) (position.y + Math.sin(angle) * (WIDTH + 20)));
            Laser laser = new Laser(HEIGHT, startPosition, FORCE, angle);
            ENV.addLaser(laser);
            coolDownCounter += TIME_TO_SHOOT;
            return 10;
        } 
        return 0;
    }

    @Override
    public void controls(HashSet<Character> controls) {
        active = controls.contains(ACT_KEY);
    }

}
