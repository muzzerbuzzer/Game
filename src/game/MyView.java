package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */



/**
 * different backgrounds in the game
 */
public class MyView  extends UserView{
    private final Image background0, background1, background2, background3, background4;
    private Game game;


    public MyView(World world, int width, int height, Game game) {
        super (world, width, height);
        this.game = game;
        background0 = new ImageIcon("data/instructions.png").getImage();
        background1 = new ImageIcon("data/background1.png").getImage();
        background2 = new ImageIcon("data/background2.png").getImage();
        background3 = new ImageIcon("data/background3.png").getImage();
        background4 = new ImageIcon("data/background4.png").getImage();

    }

    /** Backgrounds for the levels */
    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel() == 0) {
            g.drawImage(background0, 0, 0, this);
        }
        if (game.getLevel() == 1) {
            g.drawImage(background1, 0, 0, this);
        }
        else if (game.getLevel() == 2) {
            g.drawImage(background2, 0, 0, this);
        }
        else if (game.getLevel() == 3) {
            g.drawImage(background3, 0, 0, this);
        } else if (game.getLevel() == 4) {
            g.drawImage(background4, 0, 0, this);
        }
    }


    /**
     * Foreground to set the view for lives and coins
     */
    @Override
    protected void paintForeground(Graphics2D g){
        g.setColor(Color.BLACK);

        g.setFont(new Font("Emulogic", Font.BOLD, 15));

        g.drawString("coins: " + game.getPlayer().getCoinCount(), 10f,72f);

        Image heart = Toolkit.getDefaultToolkit().getImage("data/heart.png");

        for (int i=0; i < game.getPlayer().getLiveCount(); i++){
            g.drawImage(heart, 10+(i*40), 10, this);
        }
    }
}
