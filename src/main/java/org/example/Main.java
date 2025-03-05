package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Phone Keypad");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Keypad keypad = new Keypad(frame.getContentPane());
            frame.pack();
            frame.setVisible(true);
        });
    }
}