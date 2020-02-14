package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class player {
  board playboard;
  ArrayList<stash> mystash;

  //the place_stash method of stash add a list of blocks with their cordinates initialized to the stash blocks, then we pass the stash to the board, board change the states based on the blocks and bind them with the stash.
  public void place_stash(int[] cordinate, char orient, stash playstash) {
    playstash.place_stash(cordinate[0], cordinate[1], orient);
    playboard.place_block(playstash);
  }
}
