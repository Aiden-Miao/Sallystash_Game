package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class stash {
  //private string shape;
  private char color;
  private block beginblock;//the beginning of the block
  private ArrayList<block> allblock;//all the block inside
    
  //put a stash in here
  //add all the block into this stash
  public stash(int x, int y, char direction) {
    beginblock = new block(x, y);
    allblock.add(beginblock);
    /*
    if (direction == 'H' || direction == 'h') {
      allblock.add(new block(x + 1, y));
      allblock.add(new block(x + 2, y));
      allblock.add(new block(x + 3, y));
    }
    else if (direction == 'V' || direction == 'v') {
      allblock.add(new block(x, y + 1));
      allblock.add(new block(x, y + 2));
      allblock.add(new block(x, y + 3));
    }    
    */
  }
   
  public ArrayList<block> getallblock() {
    return allblock;
  }
}
