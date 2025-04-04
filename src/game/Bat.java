package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * the bat character in the game
 */
public class Bat extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.484f,0.49f, 0.482f,0.486f, 0.474f,-0.47f, -0.478f,-0.474f, -0.486f,0.472f);

    private static final BodyImage image =
            new BodyImage("data/bat.gif", 1f);


    public Bat(World world) {
        super(world, shape);
        addImage(image);
    }



}

