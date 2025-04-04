package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Doors in a game. When the hero collides with a door, if
 * the current level is complete the game is advanced to the
 * next level.
 */
public class Door extends StaticBody {

    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new PolygonShape(-0.24f,0.218f, -0.058f,0.488f, 0.064f,0.484f, 0.226f,0.254f, 0.204f,-0.296f, 0.044f,-0.488f, -0.182f,-0.454f, -0.24f,0.198f));
        addImage(new BodyImage("data/door.gif", 2.5f));
    }
}

