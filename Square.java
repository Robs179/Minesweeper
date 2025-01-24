package Minesweeper;

import java.awt.Color;

public abstract class Square {

    public boolean flagged, clicked;
    int bombs;
    int i, j;
    Color c;

    public Square(int i, int j) {
        flagged = false;
        clicked = false;
        bombs = -1;
        this.i = i;
        this.j = j;
    }

    @Override
    public abstract String toString();
    public void setColor(Color color){
        this.c = color;
    }
}
