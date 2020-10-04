package celestialwars.server.ships;

import celestialwars.server.env.Environment;
import celestialwars.server.ships.parts.BasicCannon;
import celestialwars.server.ships.parts.BasicHull;
import celestialwars.server.ships.parts.BasicRocket;
import celestialwars.server.ships.parts.Part;
import celestialwars.server.ships.parts.PolygonHull;
import celestialwars.server.ships.parts.ReverseRocket;
import celestialwars.server.ships.parts.TriangleHull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointDef;
import org.jbox2d.dynamics.joints.PulleyJointDef;

public class CustomShip extends SpaceShip {

    char[] controlKeys;

    String creationCode;
    
    final Environment ENV;

    /*
    TriangleDef 4 22 3 TriangleDef 4 24 2 TriangleDef 6 20 3 BasicHullDef 6 22 3 BasicHullDef 6 24 2 TriangleDef 8 18 3 BasicHullDef 8 20 3 TriangleDef 8 22 1 TriangleDef 10 10 3 BasicHullDef 10 12 0 BasicHullDef 10 14 0 BasicHullDef 10 16 2 BasicHullDef 10 18 3 TriangleDef 10 20 1 TriangleDef 12 8 3 BasicHullDef 12 10 0 TriangleDef 12 12 1 TriangleDef 12 14 0 BasicHullDef 12 16 3 TriangleDef 12 18 1 TriangleDef 12 22 3 BasicHullDef 12 24 2 TriangleDef 12 26 2 TriangleDef 14 6 3 BasicHullDef 14 8 0 TriangleDef 14 10 1 TriangleDef 14 12 3 BasicHullDef 14 14 0 BasicHullDef 14 16 0 TriangleDef 14 18 2 TriangleDef 14 20 3 BasicHullDef 14 22 3 BasicHullDef 14 24 2 BasicHullDef 14 26 2 TriangleDef 16 2 3 BasicHullDef 16 4 0 BasicHullDef 16 6 0 TriangleDef 16 8 1 TriangleDef 16 10 3 TriangleDef 16 12 1 TriangleDef 16 16 0 BasicHullDef 16 18 3 BasicHullDef 16 20 3 TriangleDef 16 22 1 TriangleDef 18 0 3 BasicHullDef 18 2 0 BasicHullDef 18 4 0 TriangleDef 18 6 1 TriangleDef 18 8 3 TriangleDef 18 10 1 TriangleDef 18 12 3 BasicHullDef 18 14 0 BasicHullDef 18 16 0 BasicHullDef 18 18 0 BasicHullDef 18 20 2 TriangleDef 20 0 0 BasicHullDef 20 2 0 BasicHullDef 20 4 0 TriangleDef 20 6 2 TriangleDef 20 8 0 TriangleDef 20 10 2 TriangleDef 20 12 0 BasicHullDef 20 14 0 BasicHullDef 20 16 0 BasicHullDef 20 18 0 BasicHullDef 20 20 2 TriangleDef 22 2 0 BasicHullDef 22 4 0 BasicHullDef 22 6 0 TriangleDef 22 8 2 TriangleDef 22 10 0 TriangleDef 22 12 2 TriangleDef 22 16 3 BasicHullDef 22 18 3 BasicHullDef 22 20 3 TriangleDef 22 22 2 TriangleDef 24 6 0 BasicHullDef 24 8 0 TriangleDef 24 10 2 TriangleDef 24 12 0 BasicHullDef 24 14 0 BasicHullDef 24 16 0 TriangleDef 24 18 1 TriangleDef 24 20 0 BasicHullDef 24 22 3 BasicHullDef 24 24 2 BasicHullDef 24 26 2 TriangleDef 26 8 0 BasicHullDef 26 10 0 TriangleDef 26 12 2 TriangleDef 26 14 3 BasicHullDef 26 16 3 TriangleDef 26 18 2 TriangleDef 26 22 0 BasicHullDef 26 24 2 TriangleDef 26 26 1 TriangleDef 28 10 0 BasicHullDef 28 12 0 BasicHullDef 28 14 0 BasicHullDef 28 16 0 BasicHullDef 28 18 3 TriangleDef 28 20 2 TriangleDef 30 18 0 BasicHullDef 30 20 3 TriangleDef 30 22 2 TriangleDef 32 20 0 BasicHullDef 32 22 3 BasicHullDef 32 24 2 TriangleDef 34 22 0 TriangleDef 34 24 1 
     */
    public CustomShip(Environment env, char[] controlKeys, String s) {
        super();
        ENV = env;
        this.controlKeys = controlKeys;
        creationCode = s;
    }

    @Override
    public void init(float x, float y, float heading) {
        parts = createBody(x, y, creationCode);
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == null) {
                System.out.println(i);
            }
            parts[i].init();
        }
    }

    private Part[] createBody(float x, float y, String code) {
        ArrayList<Part> parts = new ArrayList<>();
        String[] split = code.split(" ");
        int n = 0;
        for (int i = 0; i < split.length; i += 4) {
            String currentString = split[i];
            int relX = Integer.parseInt(split[i + 1]);
            int relY = Integer.parseInt(split[i + 2]);
            int angle = Integer.parseInt(split[i + 3]);
            Part part = null;
            BodyDef bd = new BodyDef();
            bd.position.set(x + relX * TILE_WIDTH, y + relY * TILE_WIDTH);
            switch (currentString) {
                case "TriangleDef":
                    part = new TriangleHull(bd, (float) (angle * Math.PI / 2));
                    break;
                case "BasicHullDef":
                    part = new BasicHull(bd);
                    break;
                case "BasicRocketDef":
                    part = new BasicRocket(bd, controlKeys[n]);
                    n++;
                    break;
                case "ReverseRocketDef":
                    part = new ReverseRocket(bd, controlKeys[n]);
                    n++;
                    break;
                case "LaserGunDef":
                    part = new BasicCannon(ENV, bd, controlKeys[n]);
                    n++;
                default:
                    break;
            }
            parts.add(part);
        }
        Part[] partArray = new Part[parts.size()];
        for (int i = 0; i < partArray.length; i++) {
            partArray[i] = parts.get(i);
        }
        return partArray;
    }

}
