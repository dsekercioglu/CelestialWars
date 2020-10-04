package celestialwars.server.env;

import celestialwars.server.ships.SpaceShip;
import celestialwars.server.ships.parts.laser.Laser;
import java.util.ArrayList;
import java.util.List;
import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;

public class Environment {

    World world;

    ArrayList<SpaceShip> spaceships = new ArrayList<>();
    ArrayList<Laser> lasers = new ArrayList<>();

    final float FORCE_REQUIRED_TO_BREAK = 10000000;

    public Environment() {
     
        world = new World(new AABB(new Vec2(0, 0), new Vec2(1800, 1800)), new Vec2(0, 0), true);
    }

    public World getWorld() {
        return world;
    }

    public void addSpaceship(SpaceShip tank) {
        tank.createTank(world);
        spaceships.add(tank);
    }

    public ArrayList<SpaceShip> getSpaceships() {
        return spaceships;
    }

    public void addLaser(Laser laser) {
        laser.createLaser(world);
        lasers.add(laser);
    }

    public ArrayList<Laser> getLasers() {
        return lasers;
    }

    public void step(float deltaTime) {
        for (int i = 0; i < spaceships.size(); i++) {
            spaceships.get(i).step(deltaTime);
        }
        world.step(deltaTime, 100);
        int jointCount = world.getJointCount();
        Joint joint = world.getJointList();
        for (int i = 0; i < jointCount; i++) {
            if (joint.getReactionForce().length() > FORCE_REQUIRED_TO_BREAK) {
                world.destroyJoint(joint);
            }
            joint = joint.getNext();
        }

        int bodyCount = world.getBodyCount();
        Body body = world.getBodyList();
        for (int i = 0; i < bodyCount; i++) {
            body = body.getNext();
        }
    }
}
