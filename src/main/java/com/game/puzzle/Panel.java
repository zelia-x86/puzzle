package com.game.puzzle;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Panel extends JPanel {
    Panel (int dim) {
        if (dim < 4) System.out.println("too small dimention");

        setLayout(new GridLayout(dim, dim, 0, 0));

        Matrix matrix = new Matrix(dim);
        Listener listener = new Listener(matrix);

        for (Button[] i : matrix.create(listener)) {
            for (Button j : i) {
                add(j);
            }            
        }
    }

}
