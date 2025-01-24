package Minesweeper;

public class Main{
    public static void main(String args[]) {
        
        Field field = new Field(16, 16);
        GUI gui = new GUI(field);
        
        
        if(field.rows==-1){
            gui.toString();
        }
        
    }
}