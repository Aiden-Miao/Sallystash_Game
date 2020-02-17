package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class player {
  private board playboard;
  private ArrayList<stash> mystash;

  public player(int h, int w) {
    playboard = new board(h, w);
  }
  //the place_stash method of stash add a list of blocks with their cordinates initialized to the stash blocks, then we pass the stash to the board, board change the states based on the blocks and bind them with the stash.
  public int put_stash(int[] cordinate, char orient, stash playstash) {
    //reset the blocks inside stash
    //we don't need to reset begining block because it's gonna be set to new value anyway
    playstash.reset_blocks();
    //add blocks into stash
    if (playstash.place_stash(cordinate[0], cordinate[1], orient) == -1) {
      System.out.println("The stash and orientation don't match, place again!\n");
      return -1;
    }
    ;
    //try to place block on the board
    if (playboard.place_block(playstash) == -1) {
      return -1;
    }
    return 0;
  }

  public int dig(int x, int y, board oppboard) {
    if ((x < 0 || x >= oppboard.get_height())|| y < 0 || y >=oppboard.get_width()){
      System.out.println("You dig a invalid position, dig again!\n");
      return -1;
    }
    else {
      oppboard.digat(x, y);
      return 0;
    }
  }

    
  public board getboard() {
    return playboard;
  }

  
}
