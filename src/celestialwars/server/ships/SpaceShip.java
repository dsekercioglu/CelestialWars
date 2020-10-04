package celestialwars.server.ships;

import celestialwars.server.ships.parts.Part;
import java.util.ArrayList;
import java.util.HashSet;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.DistanceJointDef;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

public abstract class SpaceShip {

    
    final static int TILE_WIDTH = 5;
    final static float DISTANCE_REQ_FOR_JOINT = 5.2F;
    final static float TURN = (float) (Math.PI / 18);
    Part[] parts;
    HashSet<Character> controls = new HashSet<>();

    public abstract void init(float x, float y, float heading);

    public void setControls(HashSet<Character> keys) {
        controls = keys;
    }

    public void update() {

    }

    /**
     *
     * @param deltaTime time in seconds
     */
    public void step(float deltaTime) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].controls(controls);
            parts[i].update(deltaTime);
        }
    }

    public void createTank(World world) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].createBody(world);
        }

        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts.length; j++) {
                Vec2 posi = parts[i].position();
                Vec2 posj = parts[j].position();
                if (Math.hypot(posi.x - posj.x, posi.y - posj.y) < DISTANCE_REQ_FOR_JOINT) {
                    RevoluteJointDef djd = new RevoluteJointDef();
                    djd.initialize(parts[i].getBody(), parts[j].getBody(), parts[i].position());
                    djd.lowerAngle = 0;
                    djd.upperAngle = 0;
                    world.createJoint(djd);
                }
            }
        }
    }

    public Vec2 getPosition() {
        return parts[0].position();
    }

    public float getAngle() {
        return parts[0].angle();
    }

    public Part[] getParts() {
        return parts;
    }
}
