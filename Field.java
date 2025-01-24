package Minesweeper;

import java.util.Random;

public class Field {

    private final static int MINES = 4; //in %

    Square[][] arr;
    int rows, columms;
    Random rand = new Random();

    public Field(int rows, int columms) {
        this.rows = rows;
        this.columms = columms;
        arr = new Square[rows][columms];
        
        

    }

    public void fillArr(int x, int y){
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int p = rand.nextInt(MINES);
                if (p==0) {
                    arr[i][j] = new Mine(i, j);
                } else {
                    arr[i][j] = new Number(i, j);
                }
            }
        }

        checkSurroundingsFor(x, y, '0');

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] instanceof Number) {
                    Number nTile = (Number) arr[i][j];
                    nTile.setBombs(this.checkSurroundingsFor(i, j, 'm'));
                    nTile.setColor();
                }
            }
        }
    }

    public int checkSurroundingsFor(int i, int j, char s){
        int count = 0;
        if(s=='m'){
            try {if(arr[i-1][j-1] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i][j-1] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i+1][j-1] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i-1][j] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i+1][j] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i-1][j+1] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i][j+1] instanceof Mine){count++;}} catch (Exception e) {}
            try {if(arr[i+1][j+1] instanceof Mine){count++;}} catch (Exception e) {}
        } else if(s=='0'){
            try {arr[i-1][j-1] = new Number(i-1, j-1);} catch (Exception e) {}
            try {arr[i][j-1] = new Number(i, j-1);} catch (Exception e) {}
            try {arr[i+1][j-1] = new Number(i+1, j-1);} catch (Exception e) {}
            try {arr[i-1][j] = new Number(i-1, j);} catch (Exception e) {}
            try {arr[i][j] = new Number(i, j);} catch (Exception e) {}
            try {arr[i+1][j] = new Number(i+1, j);} catch (Exception e) {}
            try {arr[i-1][j+1] = new Number(i-1, j+1);} catch (Exception e) {}
            try {arr[i][j+1] = new Number(i, j+1);} catch (Exception e) {}
            try {arr[i+1][j+1] = new Number(i+1, j+1);} catch (Exception e) {}
        }   

        return count;
    }

    @Override
    public String toString(){
        String value = "";
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                
                if(arr[i][j] instanceof Mine){
                    value += "m";
                } else{
                    value += arr[i][j].bombs;
                }
            }
            value += "\n";
        }
        return value;
    }
}
