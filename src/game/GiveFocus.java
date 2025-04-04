package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * A mouse listener that gives the keyboard focus to a specified component.
 */
public class GiveFocus extends MouseAdapter {
    private Component target;
    
    /**
     * Initialize the listener.
     * @param target the component to be given the focus on mouseEntered().
     */
    public GiveFocus(Component target) {
        this.target = target;
    }
    
    /**
     * Called when the mouse enters a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}
