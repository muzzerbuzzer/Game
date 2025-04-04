package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 4;
    boolean faceRight = true;



    private Walker body;

    public Controller(Walker body) {

        this.body = body;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e moves using arrow keys (right, left, jump, and crouch) and attacks using keys 'z' and 'x'
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // J = jump
            Vec2 v = body.getLinearVelocity();
            if(faceRight == true)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/jump.gif", 2.25f));
            }
            else if(faceRight == false)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/jumpleft.gif", 2.25f));
            }

            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
            body.removeAllImages();
            body.addImage(new BodyImage("data/runleft.gif", 2.25f));
            faceRight = false;

        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            body.removeAllImages();
            body.addImage(new BodyImage("data/run.gif", 2.25f));
            faceRight = true;


        } else if (code == KeyEvent.VK_DOWN) {
            if(faceRight == true)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/crouch.gif", 2.25f));
            }
            else if(faceRight == false)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/crouchleft.gif", 2.25f));
            }

        } else if (code == KeyEvent.VK_Z) {
            if(faceRight == true)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/attack.gif", 2.25f));
            }
            else if(faceRight == false)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/attackleft.gif", 2.25f));
            }


        } else if (code == KeyEvent.VK_X) {

            if(faceRight == true)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/2attack.gif", 2.25f));
            }
            else if(faceRight == false)
            {
                body.removeAllImages();
                body.addImage(new BodyImage("data/2attackleft.gif", 2.25f));
            }

        }


    }



        /**
         * Handle key release events.
         *
         * @param e when any of the moving keys are released the hero goes back to its idle position
         */
        @Override
        public void keyReleased (KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_LEFT) {
                body.stopWalking();
                body.removeAllImages();
                body.addImage(new BodyImage("data/idleleft.png", 2.25f));


            } else if (code == KeyEvent.VK_RIGHT) {
                body.stopWalking();
                body.removeAllImages();
                body.addImage(new BodyImage("data/idle.png", 2.25f));


            } else if (code == KeyEvent.VK_UP) {
                if (faceRight == true) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idle.png", 2.25f));
                } else if (faceRight == false) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idleleft.png", 2.25f));
                }

            } else if (code == KeyEvent.VK_DOWN) {
                if (faceRight == true) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idle.png", 2.25f));
                } else if (faceRight == false) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idleleft.png", 2.25f));
                }

            } else if (code == KeyEvent.VK_Z) {
                if (faceRight == true) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idle.png", 2.25f));
                } else if (faceRight == false) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idleleft.png", 2.25f));
                }

            } else if (code == KeyEvent.VK_X) {
                if (faceRight == true) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idle.png", 2.25f));
                } else if (faceRight == false) {
                    body.removeAllImages();
                    body.addImage(new BodyImage("data/idleleft.png", 2.25f));
                }

            }


        }

    public void setPlayer(Hero player) {
            this.body = player;
    }
}


