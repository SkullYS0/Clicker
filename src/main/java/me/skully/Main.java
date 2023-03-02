package me.skully;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

    static int clicks = 0;
    static int strength = 5;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        JFrame frame = new JFrame("Clicker");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        JLabel countLabel = new JLabel("Clicks: 0");
        JLabel error = new JLabel("Need 30");
        panel.add(countLabel);

        JButton button = new JButton("Click me!");
        JButton upgrade = new JButton("Upgrade strength!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks+=strength;
                countLabel.setText("Clicks: " + clicks);
            }
        });
        upgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicks >= (strength * 30)) {
                    clicks -= (strength * 30);
                    strength *=2;
                    countLabel.setText("Clicks: " + clicks);
                }else{
                    error.setText("Need: " + (strength * 30));
                    error.setVisible(true);
                    Timer timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            error.setVisible(false);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();

                }
            }
        });
        panel.add(button);
        panel.add(upgrade);
        panel.add(error);
        error.setVisible(false);

        frame.setSize(700, 300);
        frame.setVisible(true);
    }
}