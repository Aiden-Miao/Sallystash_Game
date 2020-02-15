package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class board {
  private int height;
  private int width;
  private block[][] board;
  //ArrayList<stash> mystash;
  
  public board(int h, int w) {
    height = h;
    width = w;
    board = new block[h][w];
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

  //place the blocks on the board and bind them with stash
  public void place_block(stash curr_stash) {
    ArrayList<block> blocks = curr_stash.getallblock();
    for (block my_block : blocks) {
      board[my_block.getx()][my_block.gety()].occupy_block();
      board[my_block.getx()][my_block.gety()].setstash(curr_stash);
    }
  }
  
  //dig at (x,y), if we find stash, then change the state to hit
  public void digat(int x, int y) {
    if (!board[x][y].is_occupied()) {
      System.out.println("you missed!\n");
    }
    else {
      board[x][y].dig_block();
    }
  }

  public block[][] getblock() {
    return board;
  }
}
