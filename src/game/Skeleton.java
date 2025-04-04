package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * the skeleton character in the game
 */

public class Skeleton extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.276f,0.482f, 0.348f,0.482f, 0.358f,-0.48f, -0.342f,-0.488f, -0.282f,0.466f);

    private static final BodyImage image =
            new BodyImage("data/skeleton.gif", 1f);

    private int liveCount;

    public Skeleton(World world) {
        super(world, shape);
        addImage(image);
        liveCount = 1;
    }

    public int getLiveCount() {

        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("skeleton died");
    }


}
