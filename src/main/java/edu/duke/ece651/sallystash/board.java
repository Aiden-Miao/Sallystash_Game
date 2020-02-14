package edu.duke.ece651.sallystash;

import java.util.ArrayList;

import sun.nio.ch.DirectBuffer;

public class board {
  int height;
  int width;
  block[][] board;
  ArrayList<stash> mystash;
  //boolean[][] state;
  
  public board(int h, int w) {
    height = h;
    width = w;
    board = new block[h][w];
    //state = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        board[i][j] = new block();
      }
    }
  }

  int get_height() {
    return height;
  }

  int get_width() {
    return width;
  }

  //place a stash, store it in the board;
  //change the blocks, and relate the blocks
  //to current stash
  public void place_stash(int x, int y, char direct) {
    stash new_stash = new stash(x, y, direct);
    mystash.add(new_stash);
    place_block(x, y, direct);
    
  }

  public void place_block(x, y, new_stash) {
    
  }
  //dig at (x,y), if find stash change the state to hit
  public void digat(int x, int y) {
    if (!board[x][y].is_occupied()) {
      System.out.println("you missed!\n");
    }
    else {
      board[x][y].dig_block();
    }
  }

  
}
