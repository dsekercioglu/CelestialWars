package celestialwars.client.menu;

import java.awt.Color;
import processing.core.PApplet;
import processing.core.PConstants;

public class Button extends Component {

    private final int BACKGROUND_COLOR = Color.RED.getRGB();
    private final int HOVER_COLOR = new Color(200, 0, 0).getRGB();

    private String text;
    private int width;
    private int height;
    private Runnable action;
    private int background;

    private int x;
    private int y;

    public Button(String text, int width, int height, Runnable action) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.action = action;
        this.background = BACKGROUND_COLOR;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(PApplet p) {
        p.fill(background);
        p.stroke(0);
        p.rect(x, y, width, height, 5);
        p.fill(0, 255, 0);
        p.text(text, x + width / 2, y + height / 2);
    }

    public void click(int x, int y) {
        if (this.x <= x && x <= this.x + width) {
            if (this.y <= y && y <= this.y + height) {
                action.run();
            }
        }
    }

    public boolean hover(int x, int y) {
        if (this.x <= x && x <= this.x + width
                && this.y <= y && y <= this.y + height) {
            background = HOVER_COLOR;
            return true;
        } else {
            background = BACKGROUND_COLOR;
            return false;
        }
    }

}
