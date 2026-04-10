package com.game.puzzle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private Time time;

    Frame (int dim) {
        super("puzzle game");
        System.out.println("dim: "+ dim);
        Panel panel = new Panel(dim);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(dim * 60, dim * 80);
        setResizable(false);
        setLocation(500,150);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        // this.time = new Time(70);
        this.time = new Time(300 + dim * 5);
        container.add(time.label);
        container.add(panel);
        add(container);
    }

    public void exec () {
        this.time.start();
        setVisible(true);
    }
}
