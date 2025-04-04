package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Hero hero;
    private Villain villain;
    private Bat bat;
    private Ghost ghost;
    private Frog frog;
    private Boss boss;
    private Skeleton skeleton;
    private Flag flag;
    private Flag1 flag1;

    public Hero getPlayer() {

        return hero;
    }

    /**
     * Populate the world of the levels.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        // make a character
        hero = new Hero(this);
        hero.setPosition(startPosition());

        bat = new Bat(this);
        bat.setPosition(batPosition1());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);

        bat = new Bat(this);
        bat.setPosition(batPosition2());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);

        bat = new Bat(this);
        bat.setPosition(batPosition3());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);

        bat = new Bat(this);
        bat.setPosition(batPosition4());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);

        bat = new Bat(this);
        bat.setPosition(batPosition5());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);

        bat = new Bat(this);
        bat.setPosition(batPosition6());
        bat.addCollisionListener(new Pickup(hero));
        bat.setGravityScale(0);
        bat.startWalking(2.5f);

        ghost = new Ghost(this);
        ghost.setPosition(GhostPosition1());
        ghost.addCollisionListener(new Pickup(hero));

        ghost = new Ghost(this);
        ghost.setPosition(GhostPosition2());
        ghost.addCollisionListener(new Pickup(hero));
        ghost.setGravityScale(0);

        flag = new Flag(this);
        flag.setPosition(flagPosition());
        flag.setGravityScale(0);
        flag.addCollisionListener(new BatCollision(bat));

        flag1 = new Flag1(this);
        flag1.setPosition(flag1Position());
        flag1.setGravityScale(0);
        flag1.addCollisionListener(new BatCollision(bat));

        frog = new Frog(this);
        frog.setPosition(FrogPosition1());
        frog.addCollisionListener(new Pickup(hero));

        frog = new Frog(this);
        frog.setPosition(FrogPosition2());
        frog.addCollisionListener(new Pickup(hero));

        villain = new Villain(this);
        villain.setPosition(VillainPosition1());
        villain.addCollisionListener(new Pickup(hero));

        villain = new Villain(this);
        villain.setPosition(VillainPosition2());
        villain.addCollisionListener(new Pickup(hero));

        boss = new Boss(this);
        boss.setPosition(BossPosition1());
        boss.setGravityScale(0);
        boss.addCollisionListener(new Pickup(hero));

        boss = new Boss(this);
        boss.setPosition(BossPosition2());
        boss.setGravityScale(0);
        boss.addCollisionListener(new Pickup(hero));

        boss = new Boss(this);
        boss.setPosition(BossPosition3());
        boss.setGravityScale(0);
        boss.addCollisionListener(new Pickup(hero));



        game.Door door = new game.Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new game.DoorListener(game));
    }

    /** The initial position of the main player. */
    public abstract Vec2 startPosition();

    /** The initial positions of the bat. */
    public abstract Vec2 batPosition1();

    public abstract Vec2 batPosition2();

    public abstract Vec2 batPosition3();

    public abstract Vec2 batPosition4();

    public abstract Vec2 batPosition5();

    public abstract Vec2 batPosition6();

    /** The initial positions of the flag. */
    public abstract Vec2 flagPosition();

    public abstract Vec2 flag1Position();

    /** The initial positions of the frog. */
    public abstract Vec2 FrogPosition1();

    public abstract Vec2 FrogPosition2();

    /** The initial positions of the villain. */
    public abstract Vec2 VillainPosition1();

    public abstract Vec2 VillainPosition2();

    /** The initial positions of the boss. */
    public abstract Vec2 BossPosition1();

    public abstract Vec2 BossPosition2();

    public abstract Vec2 BossPosition3();

    /** The initial positions of the ghost. */
    public abstract Vec2 GhostPosition1();

    public abstract Vec2 GhostPosition2();

    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** Is this level complete? */
    public abstract boolean isCompleted();


}

