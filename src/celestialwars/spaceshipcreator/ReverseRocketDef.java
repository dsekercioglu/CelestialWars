package celestialwars.spaceshipcreator;

import processing.core.PApplet;

public class ReverseRocketDef extends Def {

    @Override
    public void draw(PApplet p) {
        p.fill(0, 255, 0);
        p.stroke(0);
        p.rect(x + 16, y, 24, WIDTH, 3);
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }


}
