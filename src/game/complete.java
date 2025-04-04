package game;

import city.cs.engine.SoundClip;
import city.cs.engine.World;


import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

/**
 * @author      Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
 * @version     2019.1
 * @since       2018.3.5
 */

public class complete extends javax.swing.JFrame{
    private JButton replayButton;
    private JButton quitButton;
    private JPanel MainPanel;
    private JTextArea pressPlayToBeginTextArea;
    private Component mainPanel1;
    Game game;



    public SoundClip gameMusic;
    private JPanel mainPanel;


    public void displayWindow() {

        try {
            gameMusic = new SoundClip("data/opening.WAV");   // Open an audio input stream
            gameMusic.setVolume(0.5);
            //gameMusic.loop();
            gameMusic.play();
        } catch (UnsupportedAudioFileException |IOException| LineUnavailableException a) {
            System.out.println(a);
        }

        JFrame frame = new JFrame("Game");

        frame.pack();
        frame.setResizable(false);
        frame.setContentPane(new JLabel(new ImageIcon("data/complete.png")));
        frame.setLayout(null);
        frame.setSize(1400, 793);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JButton b = new JButton("Replay");
        b.setBounds(450, 65, 500, 150);
        b.setSize(500,150);
        frame.add(b);
        JButton s = new JButton("Quit");
        s.setBounds(450, 550, 500, 150);
        frame.add(s);
        b.setFont(new Font("Emulogic", Font.BOLD, 15));
        s.setFont(new Font("Emulogic", Font.BOLD, 15));



        b.addActionListener(new ActionListener() {
            //Game game;
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                String action = e.getActionCommand();
                frame.setVisible(false);
                // JOptionPane.showMessageDialog(null,"ActionListener is working");
                if (action.equals("replay")) {
                    System.out.println("replay Button Pressed");
                    game.goLevel1();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameMusic.stop();


                }
            }
        });
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public Component getMainPanel1(){
        return mainPanel1;
    }
}