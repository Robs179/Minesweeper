package Minesweeper;

import java.awt.Color;

public class Number extends Square{
    public Number(int i, int j) {
        super(i, j);
        bombs = 0;
        c = Color.BLACK;
    }
    
    public void setBombs(int anzBombs) {
        bombs = anzBombs;
    }

    //@Override
    public void setColor() {
        switch (bombs) {
            case 0:
                c = new Color(224, 224, 224);  
                break;
            case 1:
                c = Color.BLUE;
                break;
            case 2:
                c = new Color(22, 140, 40);
                break;
            case 3:
                c = Color.RED;
                break;
            case 4:
                c = new Color(24, 37, 140); //Dark-Blue
                break;
            case 5:
                c = new Color(140, 22, 22); //Dark-Red
                break;
            default:
                c = Color.MAGENTA;
        }
    }

    @Override
    public String toString() {
        return ""+this.bombs;
    }


}
