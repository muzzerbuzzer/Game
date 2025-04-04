package game;

import city.cs.engine.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */


/**
 * the main character in the game
 */
public class Hero extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.76f,0.851f, 0.462f,0.839f, 0.754f,0.079f, 0.626f,-1.095f, -0.517f,-1.082f, -0.87f,-0.59f, -0.918f,0.261f, -0.772f,0.821f);

    private static final BodyImage image =
            new BodyImage("data/idle.png", 2.25f);

    private int coinCount;
    private int liveCount;


    public Hero(World world) {
        super(world, shape);
        addImage(image);
        coinCount = 0; //initialise hero with 0 coins
        liveCount = 5; //initialise hero with 5 lives



    }


    public int getCoinCount() {

        return coinCount;
    }

    public void incrementCoinCount() {
        coinCount++; //every coin pickup results in 1 coin
        System.out.println("Coin count = " + coinCount);
    }

    public int getLiveCount() {

        return liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;
        System.out.println("You lost a life :( Lives = " + liveCount);
    }

    public void decrementLiveCount3() {
        liveCount = liveCount-3;
        System.out.println("You lost 3 lives :( Lives = " + liveCount);
    }

    public void incrementLiveCount() {
        liveCount++;
        System.out.println("You got a life! Lives = " + liveCount);
    }

    public void setLifeCount(int cnt){
        liveCount = cnt;

    }

    public void setCoinCount(int cnt){
        coinCount = cnt;

    }




}
