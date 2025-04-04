package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * the villain in the game
 */

public class Villain extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.657f,-0.54f, 0.468f,-0.594f, 0.648f,0.756f, -0.598f,0.77f, -0.657f,-0.495f);

    private static final BodyImage image =
            new BodyImage("data/idle2.png", 2.25f);

    private int liveCount;

    public Villain(World world) {
        super(world, shape);
        addImage(image);
        liveCount = 3;
    }

    public int getLiveCount() {

        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("villian lives = " + liveCount);
    }



}
