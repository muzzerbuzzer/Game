package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Level 4 of the game
 */
public class Level4 extends GameLevel {

    private static final int NUM_COINS = 11;
    private Hero hero;
    private Boss boss;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(21, 0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-3.5f, -5f));

        //ceiling
        Shape ceilingShape = new BoxShape (23.5f, 0f);
        Body ceiling1 = new StaticBody(this, ceilingShape);
        ceiling1.setPosition(new Vec2(0, 13.2f));
        Body ceiling2 = new StaticBody(this, ceilingShape);
        ceiling2.setPosition(new Vec2(0, -13.2f));

        // walls
        Shape leftWallShape = new BoxShape(0f, 30, new Vec2(-19.8f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0f, 40, new Vec2(26.8f, -5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // top of floor
        Shape platformShape = new BoxShape(5.7f, 0f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(4.72f, -2.2f));

        // bottom floor
        Shape platformShape2 = new BoxShape(0.7f, 0f);
        Body platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(-1.6f, -3.5f));
        Body platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(11.1f, -3.5f));

        // extra piece of floor
        Shape platformShape4 = new BoxShape(1.5f, 0f);
        Body platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(21.7f, -5f));

        // wall on side
        Shape platformShape11 = new BoxShape(0f, 5.75f);
        Body platform11 = new StaticBody(this, platformShape11);
        platform11.setPosition(new Vec2(21.6f, 7.75f));

        // 1st & 2nd platform heights
        Shape platformShape17 = new BoxShape(0f, 0.75f);
        Body platform17 = new StaticBody(this, platformShape17);
        platform17.setPosition(new Vec2(-8f, 1.25f));
        Body platform20 = new StaticBody(this, platformShape17);
        platform20.setPosition(new Vec2(-2.4f, 1.25f));
        Body platform19 = new StaticBody(this, platformShape17);
        platform19.setPosition(new Vec2(-1f, 1.25f));
        Body platform18 = new StaticBody(this, platformShape17);
        platform18.setPosition(new Vec2(0.4f, 1.25f));

        // 2nd platform widths
        Shape platformShape5 = new BoxShape(0.75f, 0f);
        Body platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-0.2f, 2f));
        Body platform6 = new StaticBody(this, platformShape5);
        platform6.setPosition(new Vec2(-0.2f, 0.5f));

        // 1st platform height again
        Shape platformShape6 = new BoxShape(0f, 1.5f);
        Body platform16 = new StaticBody(this, platformShape6);
        platform16.setPosition(new Vec2(-3.9f, 0.5f));
        Body platform15 = new StaticBody(this, platformShape6);
        platform15.setPosition(new Vec2(-6.7f, 0.5f));

        // 1st platform width
        Shape platformShape7 = new BoxShape(2.8f, 0f);
        Body platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(-5.2f, 2f));
        Body platform8 = new StaticBody(this, platformShape7);
        platform8.setPosition(new Vec2(-5.2f, 0.5f));

        Shape platformShape8 = new BoxShape(1.45f, 0f);
        Body platform9 = new StaticBody(this, platformShape8);
        platform9.setPosition(new Vec2(-5.3f, -0.9f));

        // big platform heights
        Shape platformShape9 = new BoxShape(0f, 1.4f);
        Body platform10 = new StaticBody(this, platformShape9);
        platform10.setPosition(new Vec2(1.8f, 3.4f));
        Body platform12 = new StaticBody(this, platformShape9);
        platform12.setPosition(new Vec2(10.3f, 3.4f));

        // big platform widths
        Shape platformShape10 = new BoxShape(4.25f, 0f);
        Body platform13 = new StaticBody(this, platformShape10);
        platform13.setPosition(new Vec2(6.1f, 2f));
        Body platform14 = new StaticBody(this, platformShape10);
        platform14.setPosition(new Vec2(6.1f, 4.8f));

        // booby trap walls
        Shape platformShape12 = new BoxShape(0f, 3.1f);
        Body platform21 = new StaticBody(this, platformShape12);
        platform21.setPosition(new Vec2(17.4f, -8.1f));
        Body platform22 = new StaticBody(this, platformShape12);
        platform22.setPosition(new Vec2(20.2f, -8.1f));

        // booby trap floor
        Shape platformShape13 = new BoxShape(2f, 0f);
        Body platform23 = new StaticBody(this, platformShape13);
        platform23.setPosition(new Vec2(19f, -11.3f));

        // wall on side bottom
        Shape platformShape14 = new BoxShape(1.3f, 0f);
        Body platform24 = new StaticBody(this, platformShape14);
        platform24.setPosition(new Vec2(22.9f, 2f));


        /** add pickup between the boss and hero */
        boss = new Boss(this);
        boss.setPosition(new Vec2(-5, -10));
        boss.addCollisionListener(new Pickup(hero));

        for (int i = 0; i < NUM_COINS; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 2 - 10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }
    }


    /**
     * start positions of characters
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-22, -4);
    }

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

        return new Vec2(-40f, -40f);
    }

    @Override
    public Vec2 FrogPosition2() {

        return new Vec2(-40f, -40f);
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

        return new Vec2(-13f, -4.2f);
    }

    @Override
    public Vec2 BossPosition2() {

        return new Vec2(5f, -2.2f);
    }

    @Override
    public Vec2 BossPosition3() {

        return new Vec2(19f, 5f);
    }

    @Override
    public Vec2 GhostPosition1() {

        return new Vec2(-13f, 4f);
    }

    @Override
    public Vec2 GhostPosition2() {

        return new Vec2(13f, -4f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(15f, 10);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() >= 1;
    }
}
