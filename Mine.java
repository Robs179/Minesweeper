package Minesweeper;

import java.awt.Color;

public class Mine extends Square{

    public Mine(int i, int j) {
        super(i, j);
        bombs = -1;
        c = new Color(250, 85, 200);
    }

    @Override
    public String toString() {
        return "m";
    }
    
}
