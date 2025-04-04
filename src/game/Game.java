package game;

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
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    private int level;

    private Controller controller;

    private SoundClip gameMusic;

    private static MainMenu menu = new MainMenu();

    private static complete complete = new complete();

    /** Initialise a new Game. */
    public Game() {
        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, 1400, 793, this);

        view.setZoom(30);



        try {
            gameMusic = new SoundClip("data/1.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Multi-level game");
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        // uncomment to make the view track the hero
        //world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1400, 793);

        // start!
        world.start();
    }

    /** The player in the current level. */
    public Hero getPlayer() {

        return world.getPlayer();
    }
    public void pause(){

        world.stop();
    }
public void start() {
        world.start();
}

public void play() {

        world.start();
}


    /** Restart game. */
    public void restart() {
        world.stop();

        level = 1;
        world = new Level1();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        world.start();


        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/1.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

    }

    /** Restart level. */
    public void restartLevel() {

        if (level == 1) {
            goLevel1();

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/1.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

        } else if (level == 2) {
            goLevel2();

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/2.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

        } else if (level == 3) {
            goLevel3();

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/3.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

        } else if (level == 4) {
            goLevel4();

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/4.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
        }

    }

    //go to instructions page
    public void goLevel0() {
        world.stop();


        level = 0;
        world = new Level0();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/opening.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }


        world.start();
    }

    /**
     *The method to go to level 1 (when hero walks into door)
     */
    public void goLevel1() {
        world.stop();


        level = 1;
        world = new Level1();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/1.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        world.start();
    }

    /**
     *The method to go to level 2 (when hero walks into door)
     */
    public void goLevel2() {
        world.stop();


        level = 2;
        world = new Level2();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/2.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        world.start();
    }

    /**
     *The method to go to level 3 (when hero walks into door)
     */
    public void goLevel3() {
        world.stop();


        level = 3;
        world = new Level3();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/3.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }


        world.start();
    }

    /**
     *The method to go to level 4 (when hero walks into door)
     */
    public void goLevel4() {
        world.stop();


        level = 4;
        world = new Level4();
        world.populate(this);
        controller.setPlayer(world.getPlayer());
        view.setWorld(world);
        view.setZoom(30);

        try {
            gameMusic.stop();
            gameMusic = new SoundClip("data/4.WAV");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            gameMusic.setVolume(0.5);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }


        world.start();
    }



    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {

        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();

        Hero oldMain = world.getPlayer();

        if (level == 4) {
            complete.displayWindow();
        } else if (level == 0){
            level++;
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            //controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            controller.setPlayer(world.getPlayer());
            world.getPlayer().setLifeCount(oldMain.getLiveCount());
            world.getPlayer().setCoinCount(oldMain.getCoinCount());
            view.setZoom(30);

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/1.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }


            world.start();

        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            //controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            controller.setPlayer(world.getPlayer());
            world.getPlayer().setLifeCount(oldMain.getLiveCount());
            world.getPlayer().setCoinCount(oldMain.getCoinCount());
            view.setZoom(30);

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/2.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }


            world.start();
        } else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            //controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            controller.setPlayer(world.getPlayer());
            world.getPlayer().setLifeCount(oldMain.getLiveCount());
            world.getPlayer().setCoinCount(oldMain.getCoinCount());
            view.setZoom(30);

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/3.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

            world.start();
        } else if (level == 3) {
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            //controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            controller.setPlayer(world.getPlayer());
            world.getPlayer().setLifeCount(oldMain.getLiveCount());
            world.getPlayer().setCoinCount(oldMain.getCoinCount());
            view.setZoom(30);

            try {
                gameMusic.stop();
                gameMusic = new SoundClip("data/4.WAV");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.5);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

            world.start();
        }

    }

    public int getLevel() {

        return level;
    }


    /** Run the game. */
    public static void main(String[] args) {
        menu.displayWindow();
     
        
    }
}
