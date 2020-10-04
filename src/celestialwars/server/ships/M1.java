package celestialwars.server.ships;

import celestialwars.server.ships.parts.BasicHull;
import celestialwars.server.ships.parts.BasicRocket;
import celestialwars.server.ships.parts.Part;
import celestialwars.server.ships.parts.PolygonHull;
import celestialwars.server.ships.parts.ReverseRocket;
import java.util.HashSet;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointDef;
import org.jbox2d.dynamics.joints.PulleyJointDef;

public class M1 extends SpaceShip {

    char[] controlKeys;

    public M1(char[] controlKeys) {
        super();
        this.controlKeys = controlKeys;
    }

    @Override
    public void init(float x, float y, float heading) {
        parts = createBody(x, y, heading);
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == null) {
                System.out.println(i);
            }
            parts[i].init();
        }
    }

    private Part[] createBody(float x, float y, float heading) {
        parts = new Part[28];
        BodyDef bd1 = new BodyDef();
        bd1.position.set(x - 2.5F, y - 10F);
        parts[25] = new BasicRocket(bd1, controlKeys[0]);

        BodyDef bd2 = new BodyDef();
        bd2.position.set(x - 2.5F, y + 10F);
        parts[26] = new BasicRocket(bd2, controlKeys[1]);

        BodyDef bd3 = new BodyDef();
        bd3.position.set(x - 2.5F, y);
        parts[27] = new BasicRocket(bd3, controlKeys[2]);

        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                float relX = i * 5 + 2.5F;
                float relY = (j - 2.5F) * 5 + 2.5F;
                BodyDef bd = new BodyDef();
                bd.position.set(x + relX, y + relY);
                parts[index] = new BasicHull(bd);
                index++;
            }
        }

        return parts;
    }

}
