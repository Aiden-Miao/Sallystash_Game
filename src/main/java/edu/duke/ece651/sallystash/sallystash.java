package edu.duke.ece651.sallystash;

import java.util.ArrayList;


public class sallystash {
  int height;
  int width;
  char[][] board = new char [height][width];
  
  public class stash {
    char color;//color of stash
    int[] cordinate = new int[2];//cordinate of first block
    ArrayList<block> occupied;
    ArrayList<block> hit;
  }

  public class block {
    int cor_x;
    int cor_y;
    
    public block(int x, int y) {
      cor_x = x;
      cor_y = y;
    }
  }

  void init_board
  {
    
  }
}
