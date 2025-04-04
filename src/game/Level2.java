package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_COINS = 5;
    private Frog frog;
    private Hero hero;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(13.2f, 0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(12.8f, -6.5f));

        //ceiling
        Shape ceilingShape = new BoxShape (24f, 0f);
        Body ceiling1 = new StaticBody(this, ceilingShape);
        ceiling1.setPosition(new Vec2(0, 13.2f));

        // walls
        Shape leftWallShape = new BoxShape(0f, 40);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-23.35f, 0));
        Shape rightWallShape = new BoxShape(0f, 40);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(23.35f, 0));

        // box widths
        Shape platformShape = new BoxShape(0.85f, 0f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-0.55f, -4.95f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-2.3f, -3.3f));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-3.9f, -1.65f));
        Body platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-10.5f, 0f));
        Body platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(-13.85f, 0f));
        Body platform6 = new StaticBody(this, platformShape);
        platform6.setPosition(new Vec2(-12.2f, 1.7f));

        // top floor 1
        Shape platformShape2 = new BoxShape(5.8f, 0f);
        Body platform7 = new StaticBody(this, platformShape2);
        platform7.setPosition(new Vec2(-10.5f, -1.6f));

        // top floor 2
        Shape platformShape3 = new BoxShape(2.5f, 0f);
        Body platform8 = new StaticBody(this, platformShape3);
        platform8.setPosition(new Vec2(-20.5f, -1.6f));

        // top floor side
        Shape platformShape4 = new BoxShape(0.5f, 0f);
        Body platform9 = new StaticBody(this, platformShape4);
        platform9.setPosition(new Vec2(-23.5f, -3f));

        // bottom left wall
        Shape platformShape5 = new BoxShape(0f, 5f);
        Body platform10 = new StaticBody(this, platformShape5);
        platform10.setPosition(new Vec2(-18f, -7f));

        // bottom right wall
        Shape platformShape6 = new BoxShape(0f, 3f);
        Body platform11 = new StaticBody(this, platformShape6);
        platform11.setPosition(new Vec2(-8f, -9f));

        // bottom ceiling
        Shape platformShape7 = new BoxShape(4.15f, 0f);
        Body platform12 = new StaticBody(this, platformShape7);
        platform12.setPosition(new Vec2(-12.15f, -6.6f));

        // bottom floor
        Shape platformShape8 = new BoxShape(5f, 0f);
        Body platform13 = new StaticBody(this, platformShape8);
        platform13.setPosition(new Vec2(-13f, -11.6f));



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

        return new Vec2(20, -6f);
    } //player position

    @Override
    public Vec2 batPosition1() {

        return new Vec2(-15, -7);
    }

    @Override
    public Vec2 batPosition2() {

        return new Vec2(-20, 0);
    }

    @Override
    public Vec2 batPosition3() {

        return new Vec2(-12, 2);
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

        return new Vec2(20, 4);
    }

    @Override
    public Vec2 flagPosition() {

        return new Vec2(23.2f, 4f);
    }

    @Override
    public Vec2 flag1Position() {

        return new Vec2(-23f, 5f);
    }

    @Override
    public Vec2 FrogPosition1() {

        return new Vec2(-0.5f, -4f);
    }

    @Override
    public Vec2 FrogPosition2() {

        return new Vec2(-13f, -11.6f);
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

        return new Vec2(0f, 2f);
    }

    @Override
    public Vec2 GhostPosition2() {

        return new Vec2(-18f, 6f);
    }

    @Override
    public Vec2 doorPosition() {

        return new Vec2(-9f, -10f);
    }


    /** The hero can only advance to the next level if 30 coins are collected */
    @Override
    public boolean isCompleted() {

        return getPlayer().getCoinCount() == 30;
    }
}

