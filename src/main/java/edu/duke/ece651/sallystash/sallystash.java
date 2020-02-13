package edu.duke.ece651.sallystash;

import java.util.ArrayList;


public class sallystash {
  //one for player A, one for player B
  private stash[][] A_board;
  private stash[][] B_board;
  private int Height;
  private int Width;
  
  public sallystash(int h, int w){
    //initialize the board size
    Height = h;
    Width = w;
    A_board = new stash[h][w];
    B_board = new stash[h][w];
  }
  
  public class board {
    int getHeight() {
      return Height;
    }

    int getWidth() {
      return Width;
    }
  }

  public class stash {
    public stash(int num, char col) {
      color = col;
      amount = num;
    }
    char color;
    int len;
    int amount;
    int id;
    
    boolean occupied(int x, int y) {
    };
    
    boolean hasbeendig(int x, int y) {
    };
    
    void placeat(int x, int y, char color){
      A_board[x][y] = this;
    };
  }
    
  public class display {
    /*
  String appendtwoboard(String board1, String board2) {
    String real_board = "";
    return real_board;
  }
    */
  void draw_myboard()
  {
    String myboard = "  0|1|2|3|4|5|6|7|8|9  ";
    myboard += "               ";
    myboard += "  0|1|2|3|4|5|6|7|8|9  \n";
    for (int i = 65; i < 85; i++) {
      //here we display A's board, using A_board;
      myboard += (char)i + "  | | | | | | | | |  "+ (char)i;
      myboard += "               ";
      //here we display B's board, using b_board
      myboard += (char)i + "  | | | | | | | | |  "+ (char)i +"\n";
    }
    myboard += "  0|1|2|3|4|5|6|7|8|9  ";
    myboard += "               ";
    myboard += "  0|1|2|3|4|5|6|7|8|9  \n";
    System.out.println(myboard);
  }
  
  
  void draw_oppboard()
  {
    //System.out.println(myboard);
  }
   
   }

  
};
