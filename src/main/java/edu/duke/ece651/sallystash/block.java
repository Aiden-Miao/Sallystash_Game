package edu.duke.ece651.sallystash;

public class block {
  private int x_cor;
  private int y_cor;
  private boolean hit;
  private boolean occupied;
  private stash belong_stash;

  //get the x cordinate
  public int getx() {
    return x_cor;
  }

  //get the y cordinate
  public int gety() {
    return y_cor;
  }
  
  //get the stash block belong to
  public stash getstash() {
    return belong_stash;
  }
  
  //set which stash the block should belong to
  public void setstash(stash mystash) {
    belong_stash = mystash;
  }
  
  //initialize block
  public block() {
    hit = false;
    occupied = false;
  }
  
  //initialize the block with cordinate,
  //is_hit set default to false
  public block(int x, int y) {
    occupied = true;
    hit = false;
    x_cor = x;
    y_cor = y;
  }
  
  //occupy the block
  public int occupy_block() {
    if (occupied == true) {
      return -1;
    }
    occupied = true;
    return 0;
  }
  
  //if the block is occupied
  public boolean is_occupied() {
    return occupied;
  }
  
  //dig the block
  //maybe there is a better way
  void dig_block() {
    hit = true;
  }

  //return if the block is hit or not
  public boolean is_hit() {
    return hit;
  }
}
