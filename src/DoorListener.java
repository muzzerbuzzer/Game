package game;

import city.cs.engine.*;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level.
 */
public class DoorListener implements CollisionListener {
    private Game game;
    private SoundClip gameMusic;

    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        System.out.println("door");
        Hero player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            try {
                gameMusic = new SoundClip("data/clear.WAV");   // Open an audio input stream
                gameMusic.setVolume(1);
                gameMusic.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                System.out.println(a);
            }
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
