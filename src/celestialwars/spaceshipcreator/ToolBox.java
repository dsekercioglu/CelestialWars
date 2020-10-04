package celestialwars.spaceshipcreator;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;

public class ToolBox {

    final int WIDTH_HEIGHT = 40;
    final int COLUMNS;
    List<Draggable> buttons;

    public ToolBox(int columns) {
        COLUMNS = columns;
        buttons = new ArrayList<>();
    }

    public void addDraggable(Draggable b) {
        b.setPosition((buttons.size() % COLUMNS) * WIDTH_HEIGHT, (buttons.size() / COLUMNS) * WIDTH_HEIGHT);
        buttons.add(b);
    }

    public void draw(PApplet p) {
        for(Draggable b: buttons) {
            b.draw(p);
        }
    }

    public Draggable click(int x, int y) {
        for(Draggable b: buttons) {
            if(b.click(x, y)) {
                return b;
            }
        }
        return null;
    }

    public void hover(int x, int y) {
        for(Draggable b: buttons) {
            b.hover(x, y);
        }
    }
    
    public void setAngle(float angle) {
        for(Draggable b: buttons) {
            b.setAngle(angle);
        }
    }
}
