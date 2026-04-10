package com.game.puzzle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prompt extends JDialog {

  Prompt () {
    setTitle("puzzle game");
    setSize(360, 150);

    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    container.add(Box.createVerticalGlue());
    container.add(panel, BorderLayout.CENTER);
    container.add(Box.createVerticalGlue());

    JLabel text = new JLabel("set dimentions:");
    JTextField input = new JTextField(20);
    input.setText("6");

    JButton ok = new JButton("OK");

    input.addActionListener(e -> {
      dispose();
      this.launch_next(Integer.parseInt(e.getActionCommand()));
    });
    ok.addActionListener(e -> {
      dispose();
      this.launch_next(Integer.parseInt(input.getText()));
    });
  

    panel.add(text);
    panel.add(input);
    panel.add(ok);


    add(container);

    // pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setResizable(false);
    setVisible(true);
  }

  private void launch_next (int dim) {
    Frame game = new Frame(dim + 2);
    game.exec();
  }
  
}
