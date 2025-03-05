package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Keypad extends JPanel implements ActionListener {
    JLabel display;
    JButton numButton;
    JButton clearButton;
    JButton okButton;
    String displayContent = "";
    String[] numPadContent = {"1", "2\nabc", "3\ndef", "4\nghi", "5\njkl", "6\nmno", "7\npqrs", "8\ntuv", "9\nwxyz", "*", " 0", "#"};
    ArrayList<JButton> buttonList;
    CellPhoneWord cellPhoneWord;

    public Keypad(Container pane) {
        pane.setPreferredSize(new Dimension(400, 335));

        display = new JLabel(displayContent);
        display.setPreferredSize(new Dimension(320, 25));
        display.setBorder(BorderFactory.createLoweredBevelBorder());
        pane.add(display, BorderLayout.PAGE_START);

        buttonList = new ArrayList<>(12);
        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(4, 5, 0, 0));
        numberPanel.setPreferredSize(new Dimension(320, 260));

        for (int i = 0; i < numPadContent.length; i++) {
            numButton = new JButton(numPadContent[i]);
            numButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            numButton.setHorizontalTextPosition(SwingConstants.CENTER);
            buttonList.add(numButton);
        }

        for (int n = 0; n < buttonList.size(); n++) {
            buttonList.get(n).addActionListener(this);
            numberPanel.add(buttonList.get(n));
        }

        numberPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
        pane.add(numberPanel, BorderLayout.LINE_END);

        JPanel bottomPanel = new JPanel(new FlowLayout());

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(150, 30));
        clearButton.addActionListener(this);
        bottomPanel.add(clearButton);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(150, 30));
        okButton.addActionListener(this);
        bottomPanel.add(okButton);

        pane.add(bottomPanel, BorderLayout.PAGE_END);

        cellPhoneWord = new CellPhoneWord();

    }

    public void actionPerformed(ActionEvent e) {
        String additionalText = "";

        for (int a = 0; a < buttonList.size(); a++) {
            if (e.getSource().equals(buttonList.get(a))) {
                additionalText = numPadContent[a].split("\n")[0];
            }
        }

        if (e.getSource().equals(clearButton)) {
            display.setText("");
        } else if (e.getSource().equals(okButton)) {
            String key = display.getText().replaceAll("[*# ]", "");
            ArrayList<String> matchingWords = cellPhoneWord.getMatchingWords(key);

            if (matchingWords != null && !matchingWords.isEmpty()) {
                StringBuilder message = new StringBuilder("Matching words for key " + key + ":\n");
                for (String word : matchingWords) {
                    message.append(word).append("\n");
                }
                JOptionPane.showMessageDialog(this, message.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No words found for the given key.");
            }
        } else {
            display.setText(display.getText().concat(additionalText));
        }
    }

}