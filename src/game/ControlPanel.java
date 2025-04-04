package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;



public class ControlPanel extends Container {
    private JPanel mainPanel;
    private JButton quitButton;
    private JButton restartLevelButton;
    private JButton pauseButton1;
    private JButton restartGameButton;
    private JButton playButton;
    private JComboBox comboBox1;

    /**
     * @author Seyedehnika Pakravan, seyedehnika.pakravan@city.ac.uk
     * @version 2019.1
     * @since 2018.3.5
     */


    public ControlPanel(Game game) {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pauseButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();

            }
        });
        restartLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                game.restartLevel();


            }
        });
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();

            }

        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.play();

            }
        });

        comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Level 1", "Level 2", "Level 3", "Level 4"}));
        comboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String comboBox1Selected = (String) comboBox1.getSelectedItem();
                if (comboBox1Selected == "Level 1") {
                    game.goLevel1();
                }

                if (comboBox1Selected == "Level 2") {
                    game.goLevel2();
                }

                if (comboBox1Selected == "Level 3") {
                    game.goLevel3();
                }

                if (comboBox1Selected == "Level 4") {
                    game.goLevel4();
                }
            }
        });

    }


    public JPanel getMainPanel() {

        return mainPanel;
    }
}