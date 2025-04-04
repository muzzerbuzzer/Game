package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_COINS = 5;
    private Bat bat;
    private Hero hero;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(30, 0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-6, -11f));

        //ceiling
        Shape ceilingShape = new BoxShape (23.5f, 0f);
        Body ceiling1 = new StaticBody(this, ceilingShape);
        ceiling1.setPosition(new Vec2(0, 13.2f));
        Body ceiling2 = new StaticBody(this, ceilingShape);
        ceiling2.setPosition(new Vec2(0, -13.2f));

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






        for (int i = 0; i < 15; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }
    }


    /**
     * start positions of characters
     */
    @Override
    public Vec2 startPosition() {

        return new Vec2(2, -10);
    } //player position

    @Override
    public Vec2 batPosition1() {

        return new Vec2(-15, -5);
    }

    @Override
    public Vec2 batPosition2() {

        return new Vec2(-5, 0);
    }

    @Override
    public Vec2 batPosition3() {

        return new Vec2(4, -4);
    }

    @Override
    public Vec2 batPosition4() {

        return new Vec2(9, 13);
    }

    @Override
    public Vec2 batPosition5() {

        return new Vec2(-15, 10);
    }

    @Override
    public Vec2 batPosition6() {

        return new Vec2(20, 2);
    }

    @Override
    public Vec2 flagPosition() {

        return new Vec2(23.2f, 2f);
    }

    @Override
    public Vec2 flag1Position() {

        return new Vec2(-23f, 2f);
    }

    @Override
    public Vec2 FrogPosition1() {

        return new Vec2(-40f, 40f);
    }

    @Override
    public Vec2 FrogPosition2() {

        return new Vec2(-40f, 40f);
    }

    @Override
    public Vec2 VillainPosition1() {

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 VillainPosition2() {

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 BossPosition1() {

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 BossPosition2() {

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 BossPosition3() {

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 GhostPosition1() {

        return new Vec2(-17f, -6f);
    }

    @Override
    public Vec2 GhostPosition2() {

        return new Vec2(20f, 11f);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(20f, 9);
    }

    /** The hero can only advance to the next level if 15 coins are collected */
    @Override
    public boolean isCompleted() {

        return getPlayer().getCoinCount() == 15;
    }
}
