package celestialwars.server;

import celestialwars.client.menu.Button;
import celestialwars.client.menu.Component;
import celestialwars.client.menu.Label;
import celestialwars.server.env.Environment;
import celestialwars.server.ships.CustomShip;
import celestialwars.server.ships.M1;
import celestialwars.server.ships.M11;
import celestialwars.server.ships.SpaceShip;
import celestialwars.server.ships.parts.Part;
import celestialwars.server.ships.parts.laser.Laser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

@SuppressWarnings("serial")
public class CelestialWars extends PApplet {

    HashSet<Character> pressedKeys = new HashSet<>();

    float x = 0;
    float y = 0;

    public static Environment env = new Environment();
    
    //SpaceShip c = new CustomShip(new char[] {'w', 'w', 'q', 'e'}, "TriangleDef 2 8 3 BasicHullDef 2 9 2 BasicHullDef 2 10 2 TriangleDef 2 11 2 TriangleDef 3 7 3 BasicHullDef 3 8 2 BasicHullDef 3 9 2 BasicHullDef 3 10 2 BasicHullDef 3 11 2 TriangleDef 3 12 2 BasicRocketDef 4 4 0 BasicHullDef 4 5 0 BasicHullDef 4 6 0 BasicHullDef 4 7 0 BasicHullDef 4 8 0 BasicHullDef 4 9 0 BasicHullDef 4 10 0 BasicHullDef 4 11 0 BasicHullDef 4 12 0 BasicHullDef 4 13 0 BasicHullDef 4 14 0 BasicRocketDef 4 15 0 TriangleDef 5 2 3 BasicHullDef 5 3 0 BasicHullDef 5 4 0 BasicHullDef 5 5 0 BasicHullDef 5 6 0 BasicHullDef 5 7 2 BasicHullDef 5 8 2 BasicHullDef 5 9 2 BasicHullDef 5 10 2 BasicHullDef 5 11 2 BasicHullDef 5 12 2 BasicHullDef 5 13 0 BasicHullDef 5 14 0 BasicHullDef 5 15 0 BasicHullDef 5 16 0 TriangleDef 5 17 2 TriangleDef 6 0 3 BasicHullDef 6 1 0 BasicHullDef 6 2 0 BasicHullDef 6 3 0 BasicHullDef 6 4 2 BasicHullDef 6 5 2 BasicHullDef 6 6 2 BasicHullDef 6 7 2 BasicHullDef 6 8 2 BasicHullDef 6 9 2 BasicHullDef 6 10 2 BasicHullDef 6 11 2 BasicHullDef 6 12 2 BasicHullDef 6 13 2 BasicHullDef 6 14 2 BasicHullDef 6 15 2 BasicHullDef 6 16 0 BasicHullDef 6 17 0 BasicHullDef 6 18 0 TriangleDef 6 19 2 BasicHullDef 7 0 0 BasicHullDef 7 1 0 BasicHullDef 7 2 2 BasicHullDef 7 3 2 BasicHullDef 7 4 2 BasicHullDef 7 5 2 BasicHullDef 7 6 2 BasicHullDef 7 7 2 BasicHullDef 7 8 2 BasicHullDef 7 9 2 BasicHullDef 7 10 2 BasicHullDef 7 11 2 BasicHullDef 7 12 2 BasicHullDef 7 13 2 BasicHullDef 7 14 2 BasicHullDef 7 15 2 BasicHullDef 7 16 2 BasicHullDef 7 17 2 BasicHullDef 7 18 0 BasicHullDef 7 19 0 BasicHullDef 8 0 2 BasicHullDef 8 1 2 BasicHullDef 8 2 2 TriangleDef 8 3 1 ReverseRocketDef 8 4 0 TriangleDef 8 5 0 BasicHullDef 8 6 2 BasicHullDef 8 7 2 BasicHullDef 8 8 2 BasicHullDef 8 9 2 BasicHullDef 8 10 2 BasicHullDef 8 11 2 BasicHullDef 8 12 2 BasicHullDef 8 13 2 TriangleDef 8 14 1 ReverseRocketDef 8 15 0 TriangleDef 8 16 0 BasicHullDef 8 17 2 BasicHullDef 8 18 2 BasicHullDef 8 19 2 TriangleDef 9 0 0 BasicHullDef 9 1 1 BasicHullDef 9 2 1 BasicHullDef 9 3 1 BasicHullDef 9 4 1 BasicHullDef 9 5 1 BasicHullDef 9 6 1 BasicHullDef 9 7 1 TriangleDef 9 8 1 BasicHullDef 9 9 1 BasicHullDef 9 10 1 TriangleDef 9 11 0 BasicHullDef 9 12 1 BasicHullDef 9 13 1 BasicHullDef 9 14 1 BasicHullDef 9 15 1 BasicHullDef 9 16 1 BasicHullDef 9 17 1 BasicHullDef 9 18 1 TriangleDef 9 19 1 TriangleDef 10 1 0 BasicHullDef 10 2 0 BasicHullDef 10 3 0 BasicHullDef 10 4 0 BasicHullDef 10 5 0 BasicHullDef 10 6 0 TriangleDef 10 7 1 TriangleDef 10 8 3 BasicHullDef 10 9 1 BasicHullDef 10 10 1 TriangleDef 10 11 2 TriangleDef 10 12 0 BasicHullDef 10 13 1 BasicHullDef 10 14 1 BasicHullDef 10 15 1 BasicHullDef 10 16 1 BasicHullDef 10 17 1 TriangleDef 10 18 1 TriangleDef 11 2 0 BasicHullDef 11 3 0 BasicHullDef 11 4 0 BasicHullDef 11 5 0 BasicHullDef 11 6 3 TriangleDef 11 7 3 BasicHullDef 11 8 1 BasicHullDef 11 9 1 BasicHullDef 11 10 1 BasicHullDef 11 11 1 TriangleDef 11 12 2 BasicHullDef 11 13 3 BasicHullDef 11 14 0 BasicHullDef 11 15 0 BasicHullDef 11 16 0 TriangleDef 11 17 1 TriangleDef 12 5 0 BasicHullDef 12 6 3 BasicHullDef 12 7 1 BasicHullDef 12 8 1 BasicHullDef 12 9 1 BasicHullDef 12 10 1 BasicHullDef 12 11 1 BasicHullDef 12 12 1 BasicHullDef 12 13 3 TriangleDef 12 14 1 TriangleDef 13 6 0 BasicHullDef 13 7 1 BasicHullDef 13 8 3 BasicHullDef 13 9 3 BasicHullDef 13 10 3 BasicHullDef 13 11 3 BasicHullDef 13 12 1 TriangleDef 13 13 1 BasicHullDef 14 7 1 BasicHullDef 14 8 1 BasicHullDef 14 9 1 BasicHullDef 14 10 1 BasicHullDef 14 11 1 BasicHullDef 14 12 1 BasicHullDef 15 7 1 BasicHullDef 15 8 1 BasicHullDef 15 9 1 BasicHullDef 15 10 1 BasicHullDef 15 11 1 BasicHullDef 15 12 1 BasicHullDef 16 7 1 BasicHullDef 16 8 1 TriangleDef 16 9 1 TriangleDef 16 10 0 BasicHullDef 16 11 1 BasicHullDef 16 12 1 BasicHullDef 17 7 1 BasicHullDef 17 8 1 TriangleDef 17 9 2 TriangleDef 17 10 3 BasicHullDef 17 11 1 BasicHullDef 17 12 1 TriangleDef 18 7 0 BasicHullDef 18 8 1 BasicHullDef 18 9 1 BasicHullDef 18 10 1 BasicHullDef 18 11 1 TriangleDef 18 12 1 BasicHullDef 19 8 1 BasicHullDef 19 9 1 BasicHullDef 19 10 1 BasicHullDef 19 11 1 BasicHullDef 20 8 1 BasicHullDef 20 9 1 BasicHullDef 20 10 1 BasicHullDef 20 11 1 BasicHullDef 21 8 1 BasicHullDef 21 9 1 BasicHullDef 21 10 1 BasicHullDef 21 11 1 BasicHullDef 22 8 1 BasicHullDef 22 9 1 BasicHullDef 22 10 1 BasicHullDef 22 11 1 TriangleDef 23 8 0 BasicHullDef 23 9 1 BasicHullDef 23 10 1 TriangleDef 23 11 1 BasicHullDef 24 9 1 BasicHullDef 24 10 1 BasicHullDef 25 9 1 BasicHullDef 25 10 1 BasicHullDef 26 9 1 BasicHullDef 26 10 1 BasicHullDef 27 9 1 BasicHullDef 27 10 1 BasicHullDef 28 9 1 BasicHullDef 28 10 1 TriangleDef 29 9 0 TriangleDef 29 10 1 ");
    //SpaceShip c = new CustomShip(env, new char[] {'2', '2', '1', '3', '2', '4', '4'}, "TriangleDef 10 6 2 TriangleDef 10 7 2 TriangleDef 10 11 3 TriangleDef 10 12 3 TriangleDef 11 5 3 BasicHullDef 11 6 0 BasicHullDef 11 7 0 TriangleDef 11 8 2 BasicRocketDef 11 9 1 TriangleDef 11 10 3 BasicHullDef 11 11 2 BasicHullDef 11 12 2 TriangleDef 11 13 2 BasicHullDef 12 5 0 BasicRocketDef 12 6 0 ReverseRocketDef 12 7 0 BasicHullDef 12 8 0 BasicHullDef 12 9 2 BasicHullDef 12 10 1 ReverseRocketDef 12 11 2 BasicRocketDef 12 12 2 BasicHullDef 12 13 2 TriangleDef 13 5 0 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 3 BasicHullDef 13 9 3 BasicHullDef 13 10 3 BasicHullDef 13 11 2 BasicHullDef 13 12 2 TriangleDef 13 13 1 LaserGunDef 14 6 0 BasicHullDef 14 7 2 BasicHullDef 14 8 3 BasicHullDef 14 9 3 BasicHullDef 14 10 3 BasicHullDef 14 11 1 LaserGunDef 14 12 0 TriangleDef 15 7 0 BasicHullDef 15 8 3 BasicHullDef 15 9 3 BasicHullDef 15 10 3 TriangleDef 15 11 1 TriangleDef 16 8 0 BasicHullDef 16 9 1 TriangleDef 16 10 1");
    SpaceShip c = new CustomShip(env, new char[] {'2', '2', '1', '3', '2', '4', '4'}, "TriangleDef 10 6 2 TriangleDef 10 7 2 TriangleDef 10 11 3 TriangleDef 10 12 3 TriangleDef 11 5 3 BasicHullDef 11 6 0 BasicHullDef 11 7 0 TriangleDef 11 8 2 BasicRocketDef 11 9 1 TriangleDef 11 10 3 BasicHullDef 11 11 2 BasicHullDef 11 12 2 TriangleDef 11 13 2 BasicHullDef 12 5 0 BasicRocketDef 12 6 0 ReverseRocketDef 12 7 0 BasicHullDef 12 8 0 BasicHullDef 12 9 2 BasicHullDef 12 10 1 ReverseRocketDef 12 11 2 BasicRocketDef 12 12 2 BasicHullDef 12 13 2 TriangleDef 13 5 0 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 3 BasicHullDef 13 9 3 BasicHullDef 13 10 3 BasicHullDef 13 11 2 BasicHullDef 13 12 2 TriangleDef 13 13 1 LaserGunDef 14 6 0 BasicHullDef 14 7 2 BasicHullDef 14 8 3 BasicHullDef 14 9 3 BasicHullDef 14 10 3 BasicHullDef 14 11 1 LaserGunDef 14 12 0 TriangleDef 15 7 0 BasicHullDef 15 8 3 BasicHullDef 15 9 3 BasicHullDef 15 10 3 TriangleDef 15 11 1 TriangleDef 16 8 0 BasicHullDef 16 9 1 TriangleDef 16 10 1");

//SpaceShip c2 = new CustomShip(env, new char[] {'j', 'k', 'k', 'l'}, "TriangleDef 9 4 3 BasicHullDef 9 5 0 BasicHullDef 9 6 0 TriangleDef 9 7 2 TriangleDef 9 8 3 BasicHullDef 9 9 0 BasicHullDef 9 10 0 TriangleDef 9 11 2 BasicHullDef 10 4 3 ReverseRocketDef 10 5 0 BasicRocketDef 10 6 0 BasicHullDef 10 7 1 BasicHullDef 10 8 2 BasicRocketDef 10 9 0 ReverseRocketDef 10 10 0 BasicHullDef 10 11 2 TriangleDef 11 4 0 BasicHullDef 11 5 0 BasicHullDef 11 6 0 BasicHullDef 11 7 2 BasicHullDef 11 8 2 BasicHullDef 11 9 0 BasicHullDef 11 10 0 TriangleDef 11 11 1 TriangleDef 12 5 0 BasicHullDef 12 6 1 BasicHullDef 12 7 1 BasicHullDef 12 8 1 BasicHullDef 12 9 1 TriangleDef 12 10 1 TriangleDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 0 TriangleDef 13 9 1 BasicHullDef 14 7 0 BasicHullDef 14 8 0 TriangleDef 15 7 0 TriangleDef 15 8 1 ");
    SpaceShip c2 = new CustomShip(env, new char[] {'k', 'k', 'j', 'l'}, "TriangleDef 9 5 3 BasicHullDef 9 6 0 BasicHullDef 9 7 2 TriangleDef 9 8 2 BasicHullDef 10 5 0 BasicRocketDef 10 6 2 BasicRocketDef 10 7 2 BasicHullDef 10 8 0 TriangleDef 11 4 3 BasicHullDef 11 5 0 BasicHullDef 11 6 0 BasicHullDef 11 7 0 BasicHullDef 11 8 0 TriangleDef 11 9 2 BasicHullDef 12 4 0 ReverseRocketDef 12 5 2 BasicHullDef 12 6 0 BasicHullDef 12 7 0 ReverseRocketDef 12 8 2 BasicHullDef 12 9 0 BasicHullDef 13 4 0 BasicHullDef 13 5 0 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 0 BasicHullDef 13 9 0 TriangleDef 14 4 0 BasicHullDef 14 5 0 BasicHullDef 14 6 0 BasicHullDef 14 7 0 BasicHullDef 14 8 0 TriangleDef 14 9 1 BasicHullDef 15 5 0 BasicHullDef 15 6 0 BasicHullDef 15 7 0 BasicHullDef 15 8 0 TriangleDef 16 5 0 BasicHullDef 16 6 0 BasicHullDef 16 7 0 TriangleDef 16 8 1 BasicHullDef 17 6 0 BasicHullDef 17 7 0 TriangleDef 18 6 0 TriangleDef 18 7 1");
//SpaceShip c = new CustomShip(new char[] {'a', 'd'}, "TriangleDef 8 6 3 BasicHullDef 8 7 0 BasicHullDef 8 8 0 BasicRocketDef 8 9 0 BasicHullDef 9 7 0 BasicHullDef 9 8 0 TriangleDef 10 6 0 BasicHullDef 10 7 0 BasicHullDef 10 8 0 BasicRocketDef 10 9 0");
   //SpaceShip c2 = new CustomShip(env, new char[] {'j', 'k', 'l', 't', 't', 't'}, "ReverseRocketDef 11 6 1 BasicRocketDef 11 7 1 ReverseRocketDef 11 8 1 TriangleDef 12 5 3 BasicHullDef 12 6 1 BasicHullDef 12 7 1 BasicHullDef 12 8 1 TriangleDef 12 9 2 BasicHullDef 13 5 1 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 1 BasicHullDef 13 9 1 LaserGunDef 14 5 1 TriangleDef 14 6 0 BasicHullDef 14 7 0 TriangleDef 14 8 1 LaserGunDef 14 9 1 LaserGunDef 15 7 1");    
    //SpaceShip c2 = new CustomShip(env, new char[] {'1', '2', '3', '4', '4', '4'}, "ReverseRocketDef 11 6 1 BasicRocketDef 11 7 1 ReverseRocketDef 11 8 1 TriangleDef 12 5 3 BasicHullDef 12 6 1 BasicHullDef 12 7 1 BasicHullDef 12 8 1 TriangleDef 12 9 2 BasicHullDef 13 5 1 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 1 BasicHullDef 13 9 1 LaserGunDef 14 5 1 TriangleDef 14 6 0 BasicHullDef 14 7 0 TriangleDef 14 8 1 LaserGunDef 14 9 1 LaserGunDef 15 7 1");    

    List<Button> buttons = new LinkedList<>();
    List<Component> components = new LinkedList<>();

    @Override
    public void setup() {
    }

    @Override
    public void settings() {
        fullScreen();
        c.init(100, 100, 0);
        env.addSpaceship(c);
        c2.init(1000, 1000, 0);
        env.addSpaceship(c2);
        
//        Label label = new Label("abc");
//        label.setPosition(100, 100);
//        components.add(label);
//        
//        Button button = new Button("xyz", 100, 50, ()->System.out.println("clicked"));
//        button.setPosition(200, 300);
//        components.add(button);
//        buttons.add(button);
    }

    @Override
    public void draw() {
        
        boolean found = false;
        for (Button b: buttons) {
            if (b.hover(mouseX, mouseY)) {
                cursor(HAND);
                found = true;
                break;
            }
        }
        if (!found) {
            cursor(CROSS);
        }
        
        clear();
        
        fill(0, 0, 0);
        stroke(0, 0, 0);
        rect(0, 0, displayWidth, displayHeight);

        c.setControls(pressedKeys);
        c2.setControls(pressedKeys);
        env.step(1 / frameRate);

        fill(255, 0, 0);
        drawWorld();

        fill(0, 255, 0);
        text((int) Math.round(frameRate), 20, 20);
        

        for (Component c: components) {
            c.draw(this);
        }

    }

    public void drawPart(Part p) {
        fill(255, 0, 0);
        stroke(255, 0, 0);
        PolygonDef pd = p.getShape();
        Body b = p.getBody();
        translate(b.getPosition().x, b.getPosition().y);
        rotate(b.getAngle());
        Vec2[] vertices = pd.getVertexArray();
        beginShape();
        for (int i = 0; i < vertices.length; i++) {
            Vec2 currentVertex = vertices[i];
            vertex(currentVertex.x, currentVertex.y);
        }
        endShape();
        rotate(-b.getAngle());
        translate(-b.getPosition().x, -b.getPosition().y);
    }

    public void drawParts(Part[] parts) {
        for (int i = 0; i < parts.length; i++) {
            drawPart(parts[i]);
        }
    }
    
    public void drawLaser(Laser l) {
        fill(0, 255, 0);
        stroke(0, 255, 0);
        Vec2 position = l.position(); 
        ellipse(position.x, position.y, 5, 5);
    }
    
    public void drawWorld() {
        ArrayList<SpaceShip> spaceships = env.getSpaceships();
        ArrayList<Laser> lasers = env.getLasers();
        for(int i = 0; i < spaceships.size(); i++) {
            drawParts(spaceships.get(i).getParts());
        }
        for(int i = 0; i < lasers.size(); i++) {
            drawLaser(lasers.get(i));
        }
        System.out.println(lasers.size());
    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKeys.add(Character.toLowerCase(event.getKey()));
    }

    @Override
    public void keyReleased(KeyEvent event) {
        pressedKeys.remove(Character.toLowerCase(event.getKey()));
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        
        for (Button b: buttons) {
            b.click(event.getX(), event.getY());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{celestialwars.server.CelestialWars.class.getName()});
    }

}
