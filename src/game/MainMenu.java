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

public class MainMenu extends javax.swing.JFrame{
    private JButton startButton;
    private JButton instructionsButton;
    private JButton quitButton;
    private JButton settingsButton;
    private JButton exitButton;
    private JPanel MainPanel;
    private JTextArea pressPlayToBeginTextArea;
    private Component mainPanel1;
    Game game;
    //JLabel bg;


    public SoundClip gameMusic;


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
        frame.setContentPane(new JLabel(new ImageIcon("data/mainmenu.png")));
        frame.setLayout(null);
        frame.setSize(1400, 793);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JButton b = new JButton("Play");
        b.setBounds(450, 80, 500, 150);
        b.setSize(500,150);
        frame.add(b);
        JButton s = new JButton("Quit");
        s.setBounds(450, 550, 500, 150);
        frame.add(s);
        JButton t = new JButton("Instructions");
        t.setBounds(450, 320, 500, 150);
        frame.add(t);
        b.setFont(new Font("Emulogic", Font.BOLD, 15));
        s.setFont(new Font("Emulogic", Font.BOLD, 15));
        t.setFont(new Font("Emulogic", Font.BOLD, 15));



        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                Game game = new Game();
                String action = a.getActionCommand();
                frame.setVisible(false);
                // JOptionPane.showMessageDialog(null,"ActionListener is working");
                if (action.equals("Instructions")) {
                    System.out.println("Instruction Button Pressed");
                    game.goLevel0();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    gameMusic.stop();
                }
            }
        });





        b.addActionListener(new ActionListener() {
            //Game game;
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game();
                String action = e.getActionCommand();
                frame.setVisible(false);
                // JOptionPane.showMessageDialog(null,"ActionListener is working");
                if (action.equals("Play")) {
                    System.out.println("Play Button Pressed");
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