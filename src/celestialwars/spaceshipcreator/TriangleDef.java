package celestialwars.spaceshipcreator;

import processing.core.PApplet;

public class TriangleDef extends Def {

    @Override
    public void draw(PApplet p) {
        p.fill(255, 0, 0);
        p.stroke(0);

        float angleDegrees = (float) Math.toDegrees(angle);
        while (angleDegrees < 0) {
            angleDegrees += 360;
        }
        angleDegrees %= 360;
        float sx = angleDegrees % 270 < 45 ? 0 : 1;
        float sy = angleDegrees < 135 ? 0 : 1;
        p.beginShape();
        p.vertex(x + sx * WIDTH, y + sy * HEIGHT);
        sx = (sx + 1) % 2;
        sy = (sy + 1) % 2;
        p.vertex(x + sx * WIDTH, y + sy * HEIGHT);
        p.vertex(x + (sy + 1) % 2 * WIDTH, y + sx * HEIGHT);
        p.endShape();

    }

    @Override
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
