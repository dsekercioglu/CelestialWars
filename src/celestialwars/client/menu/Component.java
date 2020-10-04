package celestialwars.client.menu;

import processing.core.PApplet;

public abstract class Component {
    
    public abstract void setPosition(int x, int y);
    
    public abstract void draw(PApplet p);
    
}
