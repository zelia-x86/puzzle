package com.game.puzzle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matrix {
    private final int dim;
    private final List<List<Button>> matrix;
    private Listener listener;

    Matrix (int dim) {
        this.dim = dim;
        this.matrix = new ArrayList<>();
        this.listener = null;

        for (int i = 0; i < this.dim*this.dim; i++) {
            if (i % this.dim == 0) this.matrix.add(new ArrayList<Button>());
            this.matrix.get(i / this.dim).add(new Button());
        }
    }

    public Button[][] create(Listener listener) {
        this.listener = listener;
        int dim = this.dim - 2;
        List<Integer> deck = new ArrayList<Integer>();
        for (int i = 1; i < dim*dim; i++)
            deck.add(i);

        Collections.shuffle(deck);

        deck.add(0);

        int e = 0;
        for (int i = 1; i <= dim; i++) {
            for (int j = 1; j <= dim; j++) {
                this.matrix.get(i).set(j, new Button(deck.get(e++), i, j, this.listener));
            }
        }
        this.zero(this.matrix.get(dim).get(dim));

        final Button[][] array = new Button[this.dim][this.dim];
        
        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                array[i][j] = this.matrix.get(i).get(j);
            }
        }
        return array;
    }


    private void zero (Button btn) {
        btn.setText("Δ");
        btn.setEnabled(false);
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.BLACK);
    }
    
    private void number (Button btn, int num) {
        btn.setText(Integer.toString(num));
        btn.setEnabled(true);
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.WHITE);
    }

    public void cursor (int i, int j) {
        if (this.matrix.get(i - 1).get(j).getText().matches("Δ")) // up
            this.move(i, j, i-1, j);
        else if (this.matrix.get(i).get(j+1).getText().matches("Δ")) // right
            this.move(i, j, i, j+1);
        else if (this.matrix.get(i+1).get(j).getText().matches("Δ")) // down
            this.move(i, j, i+1, j);
        else if (this.matrix.get(i).get(j-1).getText().matches("Δ")) // left
            this.move(i, j, i, j-1);
    }

    private void move (int x, int y, int newx, int newy) {
        if (this.matrix.get(newx).get(newy).getText() == null)
            return;
        
        this.number(this.matrix.get(newx).get(newy), Integer.parseInt(this.matrix.get(x).get(y).getText()));
        this.zero(this.matrix.get(x).get(y));
    }
}
