package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */


/**
 * A coin
 */
public class Coin extends DynamicBody {
    private static final Shape shape = new PolygonShape( -0.394f,0.531f, 0.331f,0.545f, 0.547f,0.072f, 0.412f,-0.405f, -0.394f,-0.45f, -0.484f,-0.022f, -0.394f,0.531f);

    private static final BodyImage image =
            new BodyImage("data/coin.gif", 2.25f);
    
    public Coin(World world) {
        super(world, shape);
        addImage(image);
    }
}
