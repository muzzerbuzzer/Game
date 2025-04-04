package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */


/**
 * the boss character in the game
 */
public class Boss extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.79f,1.13f, -0.06f,1.42f, 0.77f,1.02f, 0.8f,-0.57f, 0.09f,-1.42f, -0.64f,-1.4f, -0.84f,-0.37f, -0.8f,1.07f);

    private static final BodyImage image =
            new BodyImage("data/ghost2.gif", 7f);

    private int liveCount;

    public Boss (World world) {
        super(world, shape);
        addImage(image);
        liveCount = 3;
    }

    public int getLiveCount() {

        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;

    }



}