package com.game.puzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Listener implements ActionListener {

    private Matrix matrix;

    Listener (Matrix matrix) {
        this.matrix = matrix;
    }

    public void actionPerformed (ActionEvent e) {
        String[] cmd = e.getActionCommand().split(":");
        int x = Integer.parseInt(cmd[0]);
        int y = Integer.parseInt(cmd[1]);
        this.matrix.cursor(x, y);
    }
}
