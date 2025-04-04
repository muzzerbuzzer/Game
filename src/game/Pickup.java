package game;

import city.cs.engine.*;
import city.cs.engine.*;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import org.jbox2d.common.Vec2;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */


/**
 * Collision listener that allows the hero to collect things, gain, and lose lives.
 */
public class Pickup implements CollisionListener {
    private Hero hero;

    private static died died = new died();

    private SoundClip gameMusic;

    public Pickup(Hero hero) {

        this.hero = hero;

    }




    @Override
    public void collide(CollisionEvent e) {
        System.out.println("collision!!");

        /** collision between coin and hero */
        if (e.getReportingBody() instanceof Coin && e.getOtherBody() == hero) {

            try {
                gameMusic = new SoundClip("data/coin.WAV");   // Open an audio input stream
                gameMusic.setVolume(1);
                gameMusic.play();
                System.out.println("sound");
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                System.out.println(a);
            }

            hero.incrementCoinCount();
            e.getReportingBody().destroy();

            /** collision between villain and hero */
        } else if (e.getReportingBody() instanceof Villain && e.getOtherBody() == hero) { // collision with villain makes hero lose a life

            try {
                gameMusic = new SoundClip("data/lifelost.WAV");   // Open an audio input stream
                gameMusic.setVolume(1);
                gameMusic.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                System.out.println(a);
            }

            hero.decrementLiveCount();
            e.getReportingBody().destroy();

            if (hero.getLiveCount() <= 0) {
                try {
                    gameMusic = new SoundClip("data/death.WAV");   // Open an audio input stream
                    gameMusic.setVolume(1);
                    gameMusic.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                    System.out.println(a);
                }
                died.displayWindow();
            }

            /** collision between bat and hero */
        } else if (e.getReportingBody() instanceof Bat && e.getOtherBody() == hero) { //collision with bat ends the game

            try {
                gameMusic = new SoundClip("data/death.WAV");   // Open an audio input stream
                gameMusic.setVolume(1);
                gameMusic.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                System.out.println(a);
            }

            System.out.println("oh no! you died :( ");
            died.displayWindow();

            /** collision between ghost and hero */
        } else if (e.getReportingBody() instanceof Ghost && e.getOtherBody() == hero) { // collision with ghost gives extra life

            try {
                gameMusic = new SoundClip("data/life.WAV");   // Open an audio input stream
                gameMusic.setVolume(1);
                gameMusic.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                System.out.println(a);
            }

            hero.incrementLiveCount();
            e.getReportingBody().destroy();

            /** collision between frog and hero */
        } else if (e.getReportingBody() instanceof Frog && e.getOtherBody() == hero) { // collision with frog pauses game for 5 seconds
            e.getReportingBody().destroy();
            System.out.println("oops! 5 second pause");
            int delay = 5000; // number of milliseconds to sleep (5 seconds)

            long start = System.currentTimeMillis();
            while (start >= System.currentTimeMillis() - delay) ;

            /** collision between boss and hero */
            } else if (e.getReportingBody() instanceof Boss && e.getOtherBody() == hero) { // collision with boss makes hero lose 3 livea


            hero.decrementLiveCount3();

            if (hero.getLiveCount() <= 0) {
                try {
                    gameMusic = new SoundClip("data/death.WAV");   // Open an audio input stream
                    gameMusic.setVolume(1);
                    gameMusic.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException a) {
                    System.out.println(a);
                }
                died.displayWindow();
            }

        }

        }



    }




