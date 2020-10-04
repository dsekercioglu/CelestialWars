/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celestialwars.spaceshipcreator;

import java.util.ArrayList;
import java.util.List;
import processing.core.PApplet;
import static processing.core.PConstants.P3D;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 *
 * @author doruksekercioglu
 */
public class Main extends PApplet {

    final int WIDTH = 1200;
    final int HEIGHT = 600;

    int angleCoefficient = 0;

    ToolBox toolBox;

    Def pickedDef = null;

    //Hangar hangar = new Hangar(100, 100, "TriangleDef 2 11 3 TriangleDef 2 12 2 TriangleDef 3 10 3 BasicHullDef 3 11 3 BasicHullDef 3 12 2 BasicRocketDef 3 13 0 TriangleDef 4 9 3 BasicHullDef 4 10 3 TriangleDef 4 11 1 TriangleDef 5 5 3 BasicHullDef 5 6 0 BasicHullDef 5 7 0 BasicHullDef 5 8 2 BasicHullDef 5 9 3 TriangleDef 5 10 1 TriangleDef 6 4 3 BasicHullDef 6 5 0 TriangleDef 6 6 1 TriangleDef 6 7 0 BasicHullDef 6 8 3 TriangleDef 6 9 1 TriangleDef 6 11 3 BasicHullDef 6 12 2 TriangleDef 6 13 2 TriangleDef 7 3 3 BasicHullDef 7 4 0 TriangleDef 7 5 1 TriangleDef 7 6 3 BasicHullDef 7 7 0 BasicHullDef 7 8 0 TriangleDef 7 9 2 TriangleDef 7 10 3 BasicHullDef 7 11 3 BasicHullDef 7 12 2 BasicHullDef 7 13 2 BasicRocketDef 7 14 0 TriangleDef 8 1 3 BasicHullDef 8 2 0 BasicHullDef 8 3 0 TriangleDef 8 4 1 TriangleDef 8 5 3 TriangleDef 8 6 1 TriangleDef 8 8 0 BasicHullDef 8 9 3 BasicHullDef 8 10 3 TriangleDef 8 11 1 TriangleDef 9 0 3 BasicHullDef 9 1 0 BasicHullDef 9 2 0 TriangleDef 9 3 1 TriangleDef 9 4 3 TriangleDef 9 5 1 TriangleDef 9 6 3 BasicHullDef 9 7 0 BasicHullDef 9 8 0 BasicHullDef 9 9 0 BasicHullDef 9 10 2 BasicRocketDef 9 11 0 TriangleDef 10 0 0 BasicHullDef 10 1 0 BasicHullDef 10 2 0 TriangleDef 10 3 2 TriangleDef 10 4 0 TriangleDef 10 5 2 TriangleDef 10 6 0 BasicHullDef 10 7 0 BasicHullDef 10 8 0 BasicHullDef 10 9 0 BasicHullDef 10 10 2 BasicRocketDef 10 11 0 TriangleDef 11 1 0 BasicHullDef 11 2 0 BasicHullDef 11 3 0 TriangleDef 11 4 2 TriangleDef 11 5 0 TriangleDef 11 6 2 TriangleDef 11 8 3 BasicHullDef 11 9 3 BasicHullDef 11 10 3 TriangleDef 11 11 2 TriangleDef 12 3 0 BasicHullDef 12 4 0 TriangleDef 12 5 2 TriangleDef 12 6 0 BasicHullDef 12 7 0 BasicHullDef 12 8 0 TriangleDef 12 9 1 TriangleDef 12 10 0 BasicHullDef 12 11 3 BasicHullDef 12 12 2 BasicHullDef 12 13 2 BasicRocketDef 12 14 0 TriangleDef 13 4 0 BasicHullDef 13 5 0 TriangleDef 13 6 2 TriangleDef 13 7 3 BasicHullDef 13 8 3 TriangleDef 13 9 2 TriangleDef 13 11 0 BasicHullDef 13 12 2 TriangleDef 13 13 1 TriangleDef 14 5 0 BasicHullDef 14 6 0 BasicHullDef 14 7 0 BasicHullDef 14 8 0 BasicHullDef 14 9 3 TriangleDef 14 10 2 TriangleDef 15 9 0 BasicHullDef 15 10 3 TriangleDef 15 11 2 TriangleDef 16 10 0 BasicHullDef 16 11 3 BasicHullDef 16 12 2 BasicRocketDef 16 13 0 TriangleDef 17 11 0 TriangleDef 17 12 1 ");    @Override
    
   // Hangar hangar = new Hangar(100, 100, "TriangleDef 9 4 3 BasicRocketDef 9 5 0 TriangleDef 9 6 2 TriangleDef 9 12 3 BasicRocketDef 9 13 0 TriangleDef 9 14 2 BasicHullDef 10 4 3 BasicHullDef 10 5 3 BasicHullDef 10 6 3 BasicRocketDef 10 7 0 TriangleDef 10 8 2 TriangleDef 10 10 3 BasicRocketDef 10 11 0 BasicHullDef 10 12 3 BasicHullDef 10 13 3 BasicHullDef 10 14 3 BasicHullDef 11 4 3 BasicHullDef 11 5 3 BasicHullDef 11 6 3 BasicHullDef 11 7 0 BasicHullDef 11 8 0 BasicHullDef 11 9 0 BasicHullDef 11 10 0 BasicHullDef 11 11 3 BasicHullDef 11 12 3 BasicHullDef 11 13 3 BasicHullDef 11 14 3 BasicHullDef 12 4 3 BasicHullDef 12 5 3 BasicHullDef 12 6 0 BasicHullDef 12 7 0 BasicHullDef 12 8 0 BasicHullDef 12 9 3 BasicHullDef 12 10 0 BasicHullDef 12 11 0 BasicHullDef 12 12 3 BasicHullDef 12 13 3 BasicHullDef 12 14 3 BasicHullDef 13 4 3 BasicHullDef 13 5 3 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 0 BasicHullDef 13 9 0 BasicHullDef 13 10 0 BasicHullDef 13 11 0 BasicHullDef 13 12 3 BasicHullDef 13 13 3 BasicHullDef 13 14 3 TriangleDef 14 4 0 BasicHullDef 14 5 3 BasicHullDef 14 6 0 BasicHullDef 14 7 2 BasicHullDef 14 8 2 BasicHullDef 14 9 0 BasicHullDef 14 10 0 BasicHullDef 14 11 0 BasicHullDef 14 12 3 BasicHullDef 14 13 3 TriangleDef 14 14 1 BasicHullDef 15 5 0 BasicHullDef 15 6 0 BasicHullDef 15 7 0 BasicHullDef 15 8 0 BasicHullDef 15 9 0 BasicHullDef 15 10 0 BasicHullDef 15 11 0 BasicHullDef 15 12 0 BasicHullDef 15 13 3 BasicHullDef 16 5 0 BasicHullDef 16 6 0 BasicHullDef 16 7 0 BasicHullDef 16 8 0 BasicHullDef 16 9 0 BasicHullDef 16 10 0 BasicHullDef 16 11 0 BasicHullDef 16 12 0 BasicHullDef 16 13 3 BasicHullDef 17 5 2 BasicHullDef 17 6 2 BasicHullDef 17 7 2 BasicHullDef 17 8 2 BasicHullDef 17 9 2 BasicHullDef 17 10 2 BasicHullDef 17 11 2 BasicHullDef 17 12 2 BasicHullDef 17 13 2 BasicHullDef 18 5 2 BasicHullDef 18 6 2 BasicHullDef 18 7 2 BasicHullDef 18 8 1 BasicHullDef 18 9 1 BasicHullDef 18 10 1 BasicHullDef 18 11 2 BasicHullDef 18 12 2 BasicHullDef 18 13 2 TriangleDef 19 5 0 BasicHullDef 19 6 2 BasicHullDef 19 7 2 BasicHullDef 19 8 1 BasicHullDef 19 9 1 BasicHullDef 19 10 1 BasicHullDef 19 11 2 BasicHullDef 19 12 2 TriangleDef 19 13 1 BasicHullDef 20 6 2 BasicHullDef 20 7 2 BasicHullDef 20 8 1 BasicHullDef 20 9 1 BasicHullDef 20 10 1 BasicHullDef 20 11 2 BasicHullDef 20 12 2 BasicHullDef 21 6 2 BasicHullDef 21 7 2 BasicHullDef 21 8 1 BasicHullDef 21 9 1 BasicHullDef 21 10 1 BasicHullDef 21 11 2 BasicHullDef 21 12 2 BasicHullDef 22 6 2 BasicHullDef 22 7 2 BasicHullDef 22 8 1 BasicHullDef 22 9 1 BasicHullDef 22 10 1 BasicHullDef 22 11 2 BasicHullDef 22 12 2 TriangleDef 23 5 3 BasicHullDef 23 6 2 BasicHullDef 23 7 2 BasicHullDef 23 8 1 BasicHullDef 23 9 1 BasicHullDef 23 10 1 BasicHullDef 23 11 2 BasicHullDef 23 12 2 TriangleDef 23 13 2 TriangleDef 24 4 3 BasicHullDef 24 5 3 BasicHullDef 24 6 2 BasicHullDef 24 7 2 BasicHullDef 24 8 1 BasicHullDef 24 9 1 BasicHullDef 24 10 1 BasicHullDef 24 11 2 BasicHullDef 24 12 2 BasicHullDef 24 13 3 TriangleDef 24 14 2 BasicHullDef 25 4 2 BasicHullDef 25 5 2 BasicHullDef 25 6 2 BasicHullDef 25 7 2 BasicHullDef 25 8 1 BasicHullDef 25 9 1 BasicHullDef 25 10 1 BasicHullDef 25 11 2 BasicHullDef 25 12 2 BasicHullDef 25 13 2 BasicHullDef 25 14 2 TriangleDef 26 4 0 BasicHullDef 26 5 2 BasicHullDef 26 6 2 BasicHullDef 26 7 2 BasicHullDef 26 8 1 BasicHullDef 26 9 1 BasicHullDef 26 10 1 BasicHullDef 26 11 2 BasicHullDef 26 12 2 BasicHullDef 26 13 2 TriangleDef 26 14 1 TriangleDef 27 5 0 BasicHullDef 27 6 2 BasicHullDef 27 7 2 BasicHullDef 27 8 1 BasicHullDef 27 9 1 BasicHullDef 27 10 1 BasicHullDef 27 11 2 BasicHullDef 27 12 2 TriangleDef 27 13 1 TriangleDef 28 6 0 BasicHullDef 28 7 2 BasicHullDef 28 8 1 BasicHullDef 28 9 1 BasicHullDef 28 10 1 BasicHullDef 28 11 2 TriangleDef 28 12 1 BasicHullDef 29 7 2 BasicHullDef 29 8 1 BasicHullDef 29 9 1 BasicHullDef 29 10 1 BasicHullDef 29 11 2 BasicHullDef 30 7 1 BasicHullDef 30 8 2 BasicHullDef 30 9 2 BasicHullDef 30 10 2 BasicHullDef 30 11 1 BasicHullDef 31 7 1 BasicHullDef 31 8 2 BasicHullDef 31 9 1 BasicHullDef 31 10 2 BasicHullDef 31 11 1 TriangleDef 32 7 0 BasicHullDef 32 8 2 BasicHullDef 32 9 1 BasicHullDef 32 10 2 TriangleDef 32 11 1 TriangleDef 33 8 0 BasicHullDef 33 9 1 TriangleDef 33 10 1 ");
            
    //Hangar hangar = new Hangar(100, 100, "TriangleDef 2 8 3 BasicHullDef 2 9 2 BasicHullDef 2 10 2 TriangleDef 2 11 2 TriangleDef 3 7 3 BasicHullDef 3 8 2 BasicHullDef 3 9 2 BasicHullDef 3 10 2 BasicHullDef 3 11 2 TriangleDef 3 12 2 BasicRocketDef 4 4 0 BasicHullDef 4 5 0 BasicHullDef 4 6 0 BasicHullDef 4 7 0 BasicHullDef 4 8 0 BasicHullDef 4 9 0 BasicHullDef 4 10 0 BasicHullDef 4 11 0 BasicHullDef 4 12 0 BasicHullDef 4 13 0 BasicHullDef 4 14 0 BasicRocketDef 4 15 0 TriangleDef 5 2 3 BasicHullDef 5 3 0 BasicHullDef 5 4 0 BasicHullDef 5 5 0 BasicHullDef 5 6 0 BasicHullDef 5 7 2 BasicHullDef 5 8 2 BasicHullDef 5 9 2 BasicHullDef 5 10 2 BasicHullDef 5 11 2 BasicHullDef 5 12 2 BasicHullDef 5 13 0 BasicHullDef 5 14 0 BasicHullDef 5 15 0 BasicHullDef 5 16 0 TriangleDef 5 17 2 TriangleDef 6 0 3 BasicHullDef 6 1 0 BasicHullDef 6 2 0 BasicHullDef 6 3 0 BasicHullDef 6 4 2 BasicHullDef 6 5 2 BasicHullDef 6 6 2 BasicHullDef 6 7 2 BasicHullDef 6 8 2 BasicHullDef 6 9 2 BasicHullDef 6 10 2 BasicHullDef 6 11 2 BasicHullDef 6 12 2 BasicHullDef 6 13 2 BasicHullDef 6 14 2 BasicHullDef 6 15 2 BasicHullDef 6 16 0 BasicHullDef 6 17 0 BasicHullDef 6 18 0 TriangleDef 6 19 2 BasicHullDef 7 0 0 BasicHullDef 7 1 0 BasicHullDef 7 2 2 BasicHullDef 7 3 2 BasicHullDef 7 4 2 BasicHullDef 7 5 2 BasicHullDef 7 6 2 BasicHullDef 7 7 2 BasicHullDef 7 8 2 BasicHullDef 7 9 2 BasicHullDef 7 10 2 BasicHullDef 7 11 2 BasicHullDef 7 12 2 BasicHullDef 7 13 2 BasicHullDef 7 14 2 BasicHullDef 7 15 2 BasicHullDef 7 16 2 BasicHullDef 7 17 2 BasicHullDef 7 18 0 BasicHullDef 7 19 0 BasicHullDef 8 0 2 BasicHullDef 8 1 2 BasicHullDef 8 2 2 TriangleDef 8 3 1 ReverseRocketDef 8 4 0 TriangleDef 8 5 0 BasicHullDef 8 6 2 BasicHullDef 8 7 2 BasicHullDef 8 8 2 BasicHullDef 8 9 2 BasicHullDef 8 10 2 BasicHullDef 8 11 2 BasicHullDef 8 12 2 BasicHullDef 8 13 2 TriangleDef 8 14 1 ReverseRocketDef 8 15 0 TriangleDef 8 16 0 BasicHullDef 8 17 2 BasicHullDef 8 18 2 BasicHullDef 8 19 2 TriangleDef 9 0 0 BasicHullDef 9 1 1 BasicHullDef 9 2 1 BasicHullDef 9 3 1 BasicHullDef 9 4 1 BasicHullDef 9 5 1 BasicHullDef 9 6 1 BasicHullDef 9 7 1 TriangleDef 9 8 1 BasicHullDef 9 9 1 BasicHullDef 9 10 1 TriangleDef 9 11 0 BasicHullDef 9 12 1 BasicHullDef 9 13 1 BasicHullDef 9 14 1 BasicHullDef 9 15 1 BasicHullDef 9 16 1 BasicHullDef 9 17 1 BasicHullDef 9 18 1 TriangleDef 9 19 1 TriangleDef 10 1 0 BasicHullDef 10 2 0 BasicHullDef 10 3 0 BasicHullDef 10 4 0 BasicHullDef 10 5 0 BasicHullDef 10 6 0 TriangleDef 10 7 1 TriangleDef 10 8 3 BasicHullDef 10 9 1 BasicHullDef 10 10 1 TriangleDef 10 11 2 TriangleDef 10 12 0 BasicHullDef 10 13 1 BasicHullDef 10 14 1 BasicHullDef 10 15 1 BasicHullDef 10 16 1 BasicHullDef 10 17 1 TriangleDef 10 18 1 TriangleDef 11 2 0 BasicHullDef 11 3 0 BasicHullDef 11 4 0 BasicHullDef 11 5 0 BasicHullDef 11 6 3 TriangleDef 11 7 3 BasicHullDef 11 8 1 BasicHullDef 11 9 1 BasicHullDef 11 10 1 BasicHullDef 11 11 1 TriangleDef 11 12 2 BasicHullDef 11 13 3 BasicHullDef 11 14 0 BasicHullDef 11 15 0 BasicHullDef 11 16 0 TriangleDef 11 17 1 TriangleDef 12 5 0 BasicHullDef 12 6 3 BasicHullDef 12 7 1 BasicHullDef 12 8 1 BasicHullDef 12 9 1 BasicHullDef 12 10 1 BasicHullDef 12 11 1 BasicHullDef 12 12 1 BasicHullDef 12 13 3 TriangleDef 12 14 1 TriangleDef 13 6 0 BasicHullDef 13 7 1 BasicHullDef 13 8 3 BasicHullDef 13 9 3 BasicHullDef 13 10 3 BasicHullDef 13 11 3 BasicHullDef 13 12 1 TriangleDef 13 13 1 BasicHullDef 14 7 1 BasicHullDef 14 8 1 BasicHullDef 14 9 1 BasicHullDef 14 10 1 BasicHullDef 14 11 1 BasicHullDef 14 12 1 BasicHullDef 15 7 1 BasicHullDef 15 8 1 BasicHullDef 15 9 1 BasicHullDef 15 10 1 BasicHullDef 15 11 1 BasicHullDef 15 12 1 BasicHullDef 16 7 1 BasicHullDef 16 8 1 TriangleDef 16 9 1 TriangleDef 16 10 0 BasicHullDef 16 11 1 BasicHullDef 16 12 1 BasicHullDef 17 7 1 BasicHullDef 17 8 1 TriangleDef 17 9 2 TriangleDef 17 10 3 BasicHullDef 17 11 1 BasicHullDef 17 12 1 TriangleDef 18 7 0 BasicHullDef 18 8 1 BasicHullDef 18 9 1 BasicHullDef 18 10 1 BasicHullDef 18 11 1 TriangleDef 18 12 1 BasicHullDef 19 8 1 BasicHullDef 19 9 1 BasicHullDef 19 10 1 BasicHullDef 19 11 1 BasicHullDef 20 8 1 BasicHullDef 20 9 1 BasicHullDef 20 10 1 BasicHullDef 20 11 1 BasicHullDef 21 8 1 BasicHullDef 21 9 1 BasicHullDef 21 10 1 BasicHullDef 21 11 1 BasicHullDef 22 8 1 BasicHullDef 22 9 1 BasicHullDef 22 10 1 BasicHullDef 22 11 1 TriangleDef 23 8 0 BasicHullDef 23 9 1 BasicHullDef 23 10 1 TriangleDef 23 11 1 BasicHullDef 24 9 1 BasicHullDef 24 10 1 BasicHullDef 25 9 1 BasicHullDef 25 10 1 BasicHullDef 26 9 1 BasicHullDef 26 10 1 BasicHullDef 27 9 1 BasicHullDef 27 10 1 BasicHullDef 28 9 1 BasicHullDef 28 10 1 TriangleDef 29 9 0 TriangleDef 29 10 1 ");
    
    //Hangar hangar = new Hangar(100, 100, "TriangleDef 9 4 3 BasicHullDef 9 5 0 BasicHullDef 9 6 0 TriangleDef 9 7 2 TriangleDef 9 8 3 BasicHullDef 9 9 0 BasicHullDef 9 10 0 TriangleDef 9 11 2 BasicHullDef 10 4 3 ReverseRocketDef 10 5 0 BasicRocketDef 10 6 0 BasicHullDef 10 7 1 BasicHullDef 10 8 2 BasicRocketDef 10 9 0 ReverseRocketDef 10 10 0 BasicHullDef 10 11 2 TriangleDef 11 4 0 BasicHullDef 11 5 0 BasicHullDef 11 6 0 BasicHullDef 11 7 2 BasicHullDef 11 8 2 BasicHullDef 11 9 0 BasicHullDef 11 10 0 TriangleDef 11 11 1 TriangleDef 12 5 0 BasicHullDef 12 6 1 BasicHullDef 12 7 1 BasicHullDef 12 8 1 BasicHullDef 12 9 1 TriangleDef 12 10 1 TriangleDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 0 TriangleDef 13 9 1 BasicHullDef 14 7 0 BasicHullDef 14 8 0 TriangleDef 15 7 0 TriangleDef 15 8 1 ");
    
    //Hangar hangar = new Hangar(100, 100, "TriangleDef 10 6 2 TriangleDef 10 7 2 TriangleDef 10 11 3 TriangleDef 10 12 3 TriangleDef 11 5 3 BasicHullDef 11 6 0 BasicHullDef 11 7 0 TriangleDef 11 8 2 BasicRocketDef 11 9 1 TriangleDef 11 10 3 BasicHullDef 11 11 2 BasicHullDef 11 12 2 TriangleDef 11 13 2 BasicHullDef 12 5 0 BasicRocketDef 12 6 0 ReverseRocketDef 12 7 0 BasicHullDef 12 8 0 BasicHullDef 12 9 2 BasicHullDef 12 10 1 ReverseRocketDef 12 11 2 BasicRocketDef 12 12 2 BasicHullDef 12 13 2 TriangleDef 13 5 0 BasicHullDef 13 6 0 BasicHullDef 13 7 0 BasicHullDef 13 8 3 BasicHullDef 13 9 3 BasicHullDef 13 10 3 BasicHullDef 13 11 2 BasicHullDef 13 12 2 TriangleDef 13 13 1 LaserGunDef 14 6 0 BasicHullDef 14 7 2 BasicHullDef 14 8 3 BasicHullDef 14 9 3 BasicHullDef 14 10 3 BasicHullDef 14 11 1 LaserGunDef 14 12 0 TriangleDef 15 7 0 BasicHullDef 15 8 3 BasicHullDef 15 9 3 BasicHullDef 15 10 3 TriangleDef 15 11 1 TriangleDef 16 8 0 BasicHullDef 16 9 1 TriangleDef 16 10 1");   
    
    //Hangar hangar = new Hangar(100, 100, "TriangleDef 7 6 3 BasicHullDef 7 7 2 BasicHullDef 7 8 2 BasicHullDef 7 9 2 BasicHullDef 7 10 2 BasicHullDef 7 11 2 TriangleDef 7 12 2 BasicHullDef 8 6 0 BasicHullDef 8 7 0 BasicHullDef 8 8 0 BasicHullDef 8 9 0 BasicHullDef 8 10 0 BasicHullDef 8 11 0 BasicHullDef 8 12 0 BasicHullDef 9 6 0 ReverseRocketDef 9 7 0 BasicHullDef 9 8 0 BasicHullDef 9 9 0 BasicHullDef 9 10 0 ReverseRocketDef 9 11 0 BasicHullDef 9 12 0 BasicHullDef 10 6 0 BasicHullDef 10 7 0 BasicHullDef 10 8 0 BasicRocketDef 10 9 0 BasicHullDef 10 10 0 BasicHullDef 10 11 0 BasicHullDef 10 12 0 BasicHullDef 11 6 0 BasicHullDef 11 7 0 BasicRocketDef 11 8 0 BasicHullDef 11 9 0 BasicRocketDef 11 10 0 BasicHullDef 11 11 0 BasicHullDef 11 12 0 LaserGunDef 12 6 0 TriangleDef 12 7 0 BasicHullDef 12 8 1 BasicHullDef 12 9 1 BasicHullDef 12 10 1 TriangleDef 12 11 1 LaserGunDef 12 12 0 TriangleDef 13 8 0 LaserGunDef 13 9 1 TriangleDef 13 10 1");
    
    Hangar hangar = new Hangar(100, 100);
    
    public void setup() {
        //size(WIDTH, HEIGHT, P3D);
    }

    @Override
    public void settings() {
        toolBox = new ToolBox(2);
        toolBox.addDraggable(new Draggable(new BasicHullDef()));
        toolBox.addDraggable(new Draggable(new TriangleDef()));
        toolBox.addDraggable(new Draggable(new BasicRocketDef()));
        toolBox.addDraggable(new Draggable(new ReverseRocketDef()));
        toolBox.addDraggable(new Draggable(new LaserGunDef()));
        fullScreen();

    }

    @Override
    public void draw() {
        clear();
        toolBox.hover(mouseX, mouseY);
        toolBox.draw(this);

        if (pickedDef != null) {
            pickedDef.setPosition(mouseX, mouseY);
            pickedDef.draw(this);
        }

        hangar.draw(this);

        System.out.println(hangar.getCode());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Draggable b = toolBox.click(x, y);

        hangar.add(pickedDef, x, y);
        pickedDef = null;
        if (b != null) {
            pickedDef = (Def) b.DEF.clone();
        }
    }

    public void keyPressed(KeyEvent e) {
        char key = e.getKey();
        if (key == 'd') {
            angleCoefficient++;
        } else if (key == 'a') {
            angleCoefficient--;
        }

        angleCoefficient += 4;
        angleCoefficient %= 4;
        toolBox.setAngle((float) (angleCoefficient * Math.PI / 2));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PApplet.main(new String[]{celestialwars.spaceshipcreator.Main.class.getName()});
    }
}
