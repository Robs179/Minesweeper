package Minesweeper;

import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame implements MouseListener{

  Button[][] btns;
  Field field;
  boolean firstClick = true;

  public GUI(Field field) {
    
    //create the grid of buttons
    this.field = field;
    int rows = field.rows;
    int columms = field.columms;
    btns = new Button[rows][columms];
    for (int i = 0; i < btns.length; i++) {
      for (int j = 0; j < btns[i].length; j++) {
        Button b = new Button("");
        b.setSize(50, 50); 
        b.addMouseListener(this); 
        add(b);
        btns[i][j] = b;
      }
    }
    //configure the window
    setSize(50*rows, 50*columms);
    setTitle("Minesweeper");
    setLayout(new GridLayout(rows, columms));
    setVisible(true);
    addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            dispose();
        }
    });
  }

  public static void main(String args[]){
    new GUI(new Field(20, 20));
  }

  public void flagSquare(Button b, Square s){
    if(!s.clicked){
      if(s.flagged){
        b.setLabel("");
        b.setBackground(new Color(224, 224, 224));
        s.flagged = false;
      } else{
        //b.setLabel("F");
        b.setForeground(new Color(250, 85, 200));
        b.setBackground(new Color(250, 85, 200));
        s.flagged = true;
      }
    } 
  }

  public void revealSquare(Button b, Square s){
    if(s.clicked){return;}
    b.setLabel(s.toString());
    b.setForeground(s.c);
    b.setBackground(new Color(224, 224, 224));
    s.clicked = true;
    int i = s.i;
    int j = s.j;
    if(s instanceof Mine){System.out.println("Game over!");}
    if(s.bombs == 0){
      try {revealSquare(btns[i-1][j-1], field.arr[i-1][j-1]);} catch (Exception e) {}
      try {revealSquare(btns[i][j-1], field.arr[i][j-1]);} catch (Exception e) {}
      try {revealSquare(btns[i+1][j-1], field.arr[i+1][j-1]);} catch (Exception e) {}
      try {revealSquare(btns[i-1][j], field.arr[i-1][j]);} catch (Exception e) {}
      try {revealSquare(btns[i+1][j], field.arr[i+1][j]);} catch (Exception e) {}
      try {revealSquare(btns[i-1][j+1], field.arr[i-1][j+1]);} catch (Exception e) {}
      try {revealSquare(btns[i][j+1], field.arr[i][j+1]);} catch (Exception e) {}
      try {revealSquare(btns[i+1][j+1], field.arr[i+1][j+1]);} catch (Exception e) {}
    }

  }

  @Override
  public void mousePressed(MouseEvent e) {
    Button b = (Button) e.getSource(); 
    Square s = field.arr[0][0];
    for (int i = 0; i < field.arr.length; i++) {
      for (int j = 0; j < field.arr[i].length; j++) {
        
        if(btns[i][j].equals(b)){
          if(firstClick){
            field.fillArr(i, j);
            firstClick = false;
          }
          s = field.arr[i][j];
          break;
        } 
      }
    }

    //action when you left-click a button
    if(e.getButton() == 1) {
      revealSquare(b, s);
    }

    //action when you right-click a button;
    if(e.getButton() == 3) {
      flagSquare(b, s);
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {}
  @Override
  public void mouseExited(MouseEvent e) {}
  @Override
  public void mouseClicked(MouseEvent e) {}
  @Override
  public void mouseReleased(MouseEvent e) {} 
} 
