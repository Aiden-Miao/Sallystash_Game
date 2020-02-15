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
  public int place_block(stash curr_stash) {
    ArrayList<block> blocks = curr_stash.getallblock();

    //check for invalid cordinates and overlap here.
    for (block my_block : blocks) {
      if ((my_block.getx() < 0 || my_block.getx() >= height) || (my_block.gety() < 0 || my_block.gety() >= width)) {
        System.out.println("invalid cordinates!\n");
        return -1;
      }
      
      if (board[my_block.getx()][my_block.gety()].is_occupied() == true) {
        System.out.println("Your stash is overlapping with others!\n");
        return -1;
      }
    }
    for (block my_block : blocks) {
      board[my_block.getx()][my_block.gety()].occupy_block();
      board[my_block.getx()][my_block.gety()].setstash(curr_stash);
    }
    return 0;
  }

//dig at (x,y), if we find stash, then change the state to hit
public void digat(int x, int y) {
/*
    if ((x < 0 || x >= height)|| (y < 0 || y >= width)) {
      System.out.println("You dig a invalid position!\n");
      return -1;
    }
*/
    if (board[x][y].is_occupied()) {
      System.out.println("You found a stack!\n");
      //may be better way to do this
      board[x][y].dig_block();
    }
    else {
      System.out.println("You missed!\n");
      board[x][y].dig_block();
    }
    //return 0;
  }

  public block[][] getblock() {
    return board;
  }
}
