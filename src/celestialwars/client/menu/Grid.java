package celestialwars.client.menu;

import processing.core.PApplet;

public class Grid extends Component {
    
    private int columns;
    private int rows;
    private int width;
    private int height;
    private Component[][] components;
    
    private int x;
    private int y;
    
    public Grid(int columns, int rows, int width, int height) {
        // TODO: if width % rows != 0 || width % columns != 0
        this.columns = columns;
        this.rows = rows;
        this.components = new Component[rows][columns];
    }
    
    public void setComponent(int column, int row, Component component) {
        this.components[row][column] = component;
    }
    
    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        int widthPerCol = (int)(width / columns);
        int heightPerRow = (int)(height / rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (components[j][i] != null) {
                    components[j][i].setPosition(x + i * widthPerCol, y + j * heightPerRow);
                }
            }
        }
    }
    
    @Override
    public void draw(PApplet p) {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (components[j][i] != null) {
                    components[j][i].draw(p);
                }
            }
        }
    }
    
}
