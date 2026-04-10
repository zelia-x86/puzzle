package com.game.puzzle;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Time extends Timer   {
  public JLabel label;
  private int time;

  Time (int time) {
    super(1000, null);
    addActionListener(e -> this.runner());
  
    this.time = time;

    this.label = new JLabel("Time: " + this.time);
    this.label.setFont(new Font("MS", Font.PLAIN, 40));

  }

  private void runner () {
    // System.out.println("tick: "+ this.time);
    this.label.setText("Time: " + this.time--);
    if (this.time < 60) {
      this.label.setFont(new Font("MS", Font.BOLD, 40));
      this.label.setForeground(Color.RED);
    } else if (this.time == 0)
      stop();
      // times up
  }
}
