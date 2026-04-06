package com.game.puzzle;

import javax.swing.JFrame;

public class Frame extends JFrame {
    Frame () {
        super("puzzle game");
        Panel panel = new Panel(6);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(360,480);
        setLocation(500,150);
        // setLocationRelativeTo(null);
        add(panel);
    }

    public void exec () {
        setVisible(true);
    }
}
