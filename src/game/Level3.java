package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_COINS = 5;
    private Hero hero;
    private Villain villain;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(0, 0f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        //ceiling
        Shape ceilingShape = new BoxShape (23.5f, 0f);
        Body ceiling1 = new StaticBody(this, ceilingShape);
        ceiling1.setPosition(new Vec2(0, 13.2f));
        Body ceiling2 = new StaticBody(this, ceilingShape);
        ceiling2.setPosition(new Vec2(0, -13.2f));

        // walls
        Shape leftWallShape = new BoxShape(0f, 30, new Vec2(-23.3f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0f, 40, new Vec2(23.3f, -5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make some platforms
        Shape platformShape = new BoxShape(10.8f, 0f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(14.5f, -1f));


        // bottom floor
        Shape platformShape2 = new BoxShape(13.5f, 0f);
        Body platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(-10.2f, -10.2f));


        // right wall thing
        Shape platformShape3 = new BoxShape(0f, 4.5f);
        Body platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(3.5f, -5.5f));

        // box width bottom floor right
        Shape platformShape4 = new BoxShape(1f, 0f);
        Body platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(2.4f, -8.1f));

        // box height bottom floor right
        Shape platformShape11 = new BoxShape(0f, 1f);
        Body platform11 = new StaticBody(this, platformShape11);
        platform11.setPosition(new Vec2(1.3f, -9.15f));

        // box on top floor bottom width
        Shape platformShape5 = new BoxShape(1f, 0f);
        Body platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-7.9f, -3f));

        // box on top floor top width
        Shape platformShape6 = new BoxShape(3.5f, 0f);
        Body platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(-8.4f, 3.1f));

        // box on top floor middle height
        Shape platformShape7 = new BoxShape(0f, 2f);
        Body platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(-6.9f, -1f));

        // box on top floor middle width
        Shape platformShape8 = new BoxShape(1f, 0f);
        Body platform8 = new StaticBody(this, platformShape8);
        platform8.setPosition(new Vec2(-5.8f, 1.1f));

        // box on top floor middle height
        Shape platformShape9 = new BoxShape(0f, 1f);
        Body platform9 = new StaticBody(this, platformShape9);
        platform9.setPosition(new Vec2(-4.8f, 2f));

        // bottom floor ceiling
        Shape platformShape10 = new BoxShape(7.2f, 0f);
        Body platform10 = new StaticBody(this, platformShape10);
        platform10.setPosition(new Vec2(-16.4f, -5f));

        // bottom floor ceiling small wall
        Shape platformShape12 = new BoxShape(0f, 1f);
        Body platform12 = new StaticBody(this, platformShape12);
        platform12.setPosition(new Vec2(-8.9f, -4f));

        // booby trap wall left
        Shape platformShape13 = new BoxShape(0f, 2.5f);
        Body platform13 = new StaticBody(this, platformShape13);
        platform13.setPosition(new Vec2(-21.2f, 0f));

        // booby trap wall right
        Shape platformShape14 = new BoxShape(0f, 3.55f);
        Body platform14 = new StaticBody(this, platformShape14);
        platform14.setPosition(new Vec2(-16f, 1.3f));

        // booby trap floor
        Shape platformShape15 = new BoxShape(2.5f, 0f);
        Body platform15 = new StaticBody(this, platformShape15);
        platform15.setPosition(new Vec2(-18.5f, -2f));

        //step 1
        Shape platformShape16 = new BoxShape(1f, 0f);
        Body platform16 = new StaticBody(this, platformShape16);
        platform16.setPosition(new Vec2(-23.2f, 5.2f));

        //step 2
        Shape platformShape17 = new BoxShape(0f, 1f);
        Body platform17 = new StaticBody(this, platformShape17);
        platform17.setPosition(new Vec2(-22.3f, 4.2f));

        //step 3
        Shape platformShape18 = new BoxShape(0.5f, 0f);
        Body platform18 = new StaticBody(this, platformShape18);
        platform18.setPosition(new Vec2(-21.7f, 3.1f));

        //step 4
        Shape platformShape19 = new BoxShape(1f, 0f);
        Body platform19 = new StaticBody(this, platformShape19);
        platform19.setPosition(new Vec2(-15f, 5.15f));

        //step 5
        Shape platformShape20 = new BoxShape(1.15f, 0f);
        Body platform20= new StaticBody(this, platformShape20);
        platform20.setPosition(new Vec2(-12.85f, 4.15f));

        /** add pickup between the villain and the hero */
        villain = new Villain(this);
        villain.setPosition(new Vec2(0, -10));
        villain.addCollisionListener(new Pickup(hero));

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
        return new Vec2(22, -0.8f);
    }

    @Override
    public Vec2 batPosition1() {

        return new Vec2(-15, -6);
    }

    @Override
    public Vec2 batPosition2() {

        return new Vec2(-5, 0);
    }

    @Override
    public Vec2 batPosition3() {

        return new Vec2(2, -4);
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

        return new Vec2(20, 7);
    }

    @Override
    public Vec2 flagPosition() {

        return new Vec2(23.2f, 7f);
    }

    @Override
    public Vec2 flag1Position() {

        return new Vec2(-23f, 7f);
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

        return new Vec2(5,-1);
    }

    @Override
    public Vec2 VillainPosition2() {

        return new Vec2(-13, -6f);
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

        return new Vec2(-18f, 4f);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-15f, -8f);
    }


    /** The hero can only advance to the next level if 35 coins are collected */
    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() == 35;
    }
}