package celestialwars.spaceshipcreator;

import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

public abstract class Def implements Cloneable {
    
    final int WIDTH = 40;
    final int HEIGHT = 40;
    float x;
    float y;
    float angle;

    public abstract void draw(PApplet p);

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public void setAngle(float a) {
        angle = a;
    }
    
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Def.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
