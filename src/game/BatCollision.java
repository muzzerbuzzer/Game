package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

public class BatCollision implements CollisionListener {

    private Bat bat;


    public BatCollision(Bat bat) {
        this.bat = bat;

    }

    /**
     * This method allows one bat to move back and forth across the screen while the game is running using collisions
     *
     * @param Uses the bodies "flag" and "flag1" and once bat collides with them it turns
     */

    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Flag1 && e.getOtherBody() == bat) // If bat collides with wall and is facing left
        // turn bat to face right
        {
            System.out.println("batttt");
            bat.stopWalking();
            bat.startWalking(2.5f);
            bat.removeAllImages();
            bat.addImage(new BodyImage("data/bat.gif"));
        }
        if (e.getReportingBody() instanceof Flag && e.getOtherBody() == bat) // If bat collides with wall and is facing right
        // turn bat to face left
        {
            System.out.println("batttt");
            bat.stopWalking();
            bat.startWalking(-2.5f);
            bat.removeAllImages();
            bat.addImage(new BodyImage("data/batleft.gif"));
        }

    }
}