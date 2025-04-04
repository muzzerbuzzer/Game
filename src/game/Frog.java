package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * the frog character in the game
 */
public class Frog extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.488f,0.482f, 0.488f,0.48f, 0.48f,-0.476f, -0.484f,-0.48f, -0.488f,0.462f);

    private static final BodyImage image =
            new BodyImage("data/frog.gif", 1f);

    private int liveCount;

    public Frog(World world) {
        super(world, shape);
        addImage(image);
        liveCount = 1;
    }

    public int getLiveCount() {

        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("frog died");
    }


}
