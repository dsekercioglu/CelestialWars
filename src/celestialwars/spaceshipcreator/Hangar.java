package celestialwars.spaceshipcreator;

import processing.core.PApplet;

public class Hangar {

    final int COLUMNS = 35;
    final int ROWS = 20;
    final int WIDTH_HEIGHT = 40;
    final int WIDTH = COLUMNS * WIDTH_HEIGHT;
    final int HEIGHT = ROWS * WIDTH_HEIGHT;
    final int X;
    final int Y;
    Def[][] parts = new Def[COLUMNS][ROWS];

    public Hangar(int x, int y) {
        X = x;
        Y = y;
    }

    /*
    
     */
    public Hangar(int x, int y, String code) {
        X = x;
        Y = y;
        String[] split = code.split(" ");
        for (int i = 0; i < split.length; i += 4) {
            String currentString = split[i];
            int relX = Integer.parseInt(split[i + 1]);
            int relY = Integer.parseInt(split[i + 2]);
            int angle = Integer.parseInt(split[i + 3]);
            Def def = null;
            switch (currentString) {
                case "TriangleDef":
                    def = new TriangleDef();
                    break;
                case "BasicHullDef":
                    def = new BasicHullDef();
                    break;
                case "BasicRocketDef":
                    def = new BasicRocketDef();
                    break;
                case "ReverseRocketDef":
                    def = new ReverseRocketDef();
                    break;
                case "LaserGunDef":
                    def = new LaserGunDef();
                    break;
                default:
                    break;
            }
            if (def != null) {
                def.setPosition(X + relX * WIDTH_HEIGHT, Y + relY * WIDTH_HEIGHT);
                def.setAngle((float) (angle * Math.PI / 2));
                parts[relX][relY] = def;
            }
        }
    }

    public void draw(PApplet p) {

        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                p.fill(100, 50);
                p.rect(X + i * WIDTH_HEIGHT, Y + j * WIDTH_HEIGHT, WIDTH_HEIGHT, WIDTH_HEIGHT, 5);
            }
        }
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                if (parts[i][j] != null) {
                    parts[i][j].draw(p);
                }
            }
        }
    }

    public void add(Def part, int x, int y) {
        x -= X;
        y -= Y;
        x /= WIDTH_HEIGHT;
        y /= WIDTH_HEIGHT;
        if (inBoundaries(x, y)) {
            if (part == null) {
                parts[x][y] = null;
            } else {
                parts[x][y] = part;
                part.setPosition(X + x * WIDTH_HEIGHT, Y + y * WIDTH_HEIGHT);
            }
        }
    }

    public void remove(Def part, int x, int y) {
        x -= X;
        y -= Y;
        x /= COLUMNS;
        y /= ROWS;
        if (inBoundaries(x, y)) {
            parts[x][y] = null;
        }

    }

    public boolean inBoundaries(int xIndex, int yIndex) {
        return xIndex >= 0 && xIndex < COLUMNS && yIndex >= 0 && yIndex < ROWS;
    }

    public String getCode() {
        String code = "";
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                if (parts[i][j] != null) {
                    Def def = parts[i][j];
                    code += def.getClass().getSimpleName() + " ";
                    code += (int) ((def.x - X) / WIDTH_HEIGHT) + " " + (int) ((def.y - Y) / WIDTH_HEIGHT) + " ";
                    code += (int) Math.round(def.angle / Math.PI * 2) + " ";
                }
            }
        }
        return code;
    }
}
