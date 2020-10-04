package celestialwars.spaceshipcreator;

import celestialwars.client.menu.*;
import java.awt.Color;
import processing.core.PApplet;
import processing.core.PConstants;

public class Draggable {

    private final int BACKGROUND_COLOR = new Color(0, 0, 0, 50).getRGB();
    private final int HOVER_COLOR = new Color(0, 0, 0, 100).getRGB();

    private final int WIDTH = 40;
    private final int HEIGHT = 40;

    private int background;

    private int x;
    private int y;

    Def DEF;

    public Draggable(Def def) {
        this.background = BACKGROUND_COLOR;
        DEF = def;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        DEF.setPosition(x - WIDTH / 2, y - HEIGHT / 2);
    }

    public void setAngle(float angle) {
        DEF.setAngle(angle);
    }

    public void draw(PApplet p) {
        DEF.draw(p);
        p.fill(background);
        p.stroke(0);
        p.rect(x, y, WIDTH, HEIGHT);
    }

    public boolean click(int x, int y) {
        return this.x <= x && x <= this.x + WIDTH && this.y <= y && y <= this.y + HEIGHT;
    }

    public boolean hover(int x, int y) {
        if (this.x <= x && x <= this.x + WIDTH
                && this.y <= y && y <= this.y + HEIGHT) {
            background = HOVER_COLOR;
            return true;
        } else {
            background = BACKGROUND_COLOR;
            return false;
        }
    }

}
