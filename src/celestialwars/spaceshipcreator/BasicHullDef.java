package celestialwars.spaceshipcreator;

import processing.core.PApplet;

public class BasicHullDef extends Def {

    @Override
    public void draw(PApplet p) {
        p.fill(255, 0, 0);
        p.stroke(0);
        p.rect(x, y, WIDTH, HEIGHT, 3);
    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }


}
