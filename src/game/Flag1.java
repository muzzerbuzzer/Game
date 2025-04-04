package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * a flag - for the bat collision
 */


public class Flag1 extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.0253f,0.0242f, 0.025f,0.0242f, 0.025f,0.0026f, 0.0247f,-0.0233f, -0.0244f,-0.0235f, -0.0253f,0.023f);

    private static final BodyImage image =
            new BodyImage("data/flag.png", 0.05f);

    private int liveCount;

    public Flag1(World world) {
        super(world, shape);
        addImage(image);
    }



}
