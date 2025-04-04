package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Hero hero;
    private Villain villain;
    private Bat bat;
    private Ghost ghost;
    private Frog frog;
    private Skeleton skeleton;

    
    public GameWorld() {
        super();
        
        // make the ground
        Shape groundShape = new BoxShape(30, 0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-6, -11f));
        // walls
        Shape leftWallShape = new BoxShape(0f, 30, new Vec2(-17.6f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0f, 40, new Vec2(29.3f, -5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
        Shape boxShape = new BoxShape(2, 0.2f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        platform1.addImage(new BodyImage("data/longplatform.png"));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(15, 8f));
        platform2.addImage(new BodyImage("data/longplatform.png"));


        Shape boxShape2 = new BoxShape(1, 0.2f);
        Body platform3 = new StaticBody(this, boxShape2);
        platform3.setPosition(new Vec2(4, -2.5f));
        platform3.addImage(new BodyImage("data/shortplatform.png"));
        Body platform4 = new StaticBody(this, boxShape2);
        platform4.setPosition(new Vec2(-17.5f, -6f));
        platform4.addImage(new BodyImage("data/shortplatform.png"));
        Body platform5 = new StaticBody(this, boxShape2);
        platform5.setPosition(new Vec2(10, 4f));
        platform5.addImage(new BodyImage("data/shortplatform.png"));






        // coins
        for (int i = 0; i < 15; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new Pickup(hero));
        }
    }
    
    public Hero getPlayer() {

        return hero;

    }

}
