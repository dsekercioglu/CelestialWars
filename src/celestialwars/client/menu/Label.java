package celestialwars.client.menu;

import processing.core.PApplet;

public class Label extends Component {
    
    private String text;
    
    private int x;
    private int y;
    
    public Label(String text) {
        this.text = text;
    }
    
    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        // TODO: This x and y should be top-left coordinates. Calculate center (x,y)
    }
    
    @Override
    public void draw(PApplet p) {
        p.fill(0, 255, 0);
        p.text(text, x, y);
    }
    
}
