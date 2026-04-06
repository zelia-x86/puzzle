package com.game.puzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
    Button () {
        super();
        setEnabled(false);
        setForeground(Color.BLUE);
        setBackground(Color.BLUE);
        
    }

    Button (int number) {
        super();
        setForeground(Color.BLACK);
        setBackground(Color.BLACK);
    }

    Button (int number, int x, int y, ActionListener listener) {
        super(Integer.toString(number));

        setForeground(Color.BLACK);
        setBackground(Color.WHITE);
        addActionListener(listener);
        setActionCommand(x + ":" + y);

        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
    }

}
