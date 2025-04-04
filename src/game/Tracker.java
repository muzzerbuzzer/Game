package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Pan the view to follow a particular body.
 */
public class Tracker implements StepListener {
    /** The view */
    private WorldView view;

    /** The body */
    private Body body;

    public Tracker(WorldView view, Body body) {
        this.view = view;
        this.body = body;
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition()));
    }
    
}
