package com.game.puzzle;

public class Game {

    private Frame window;

    Game () {
        this.window = new Frame();
    }

    public void run () {
        window.exec();
    }
    
}
