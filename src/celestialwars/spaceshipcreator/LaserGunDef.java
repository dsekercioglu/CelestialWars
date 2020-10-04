package celestialwars.spaceshipcreator;

import processing.core.PApplet;

public class LaserGunDef extends Def {

    @Override
    public void draw(PApplet p) {
        p.fill(0, 0, 255);
        p.stroke(0);
        p.rect(x, y + 16, WIDTH, HEIGHT - 32, 1);
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }


}
