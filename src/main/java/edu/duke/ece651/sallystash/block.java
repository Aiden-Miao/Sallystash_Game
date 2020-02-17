package edu.duke.ece651.sallystash;

public class block {
  private int x_cor;
  private int y_cor;
  private boolean hit;
  private boolean occupied;
  private boolean miss;
  private stash belong_stash;
  private boolean is_moved;
  //get the x cordinate
  public int getx() {
    return x_cor;
  }
  
  //get the y cordinate
  public int gety() {
    return y_cor;
  }
  
  //get the stash that our block belong to
  public stash getstash() {
    return belong_stash;
  }

  public void move_hit_block() {
    is_moved = true;
  }

  public boolean is_move() {
    return is_moved;
  }
  //set which stash the block should belong to
  public void setstash(stash mystash) {
    belong_stash = mystash;
  }
  
  //initialize block, is not hit or occupied
  public block() {
    is_moved = false;
    hit = false;
    occupied = false;
    miss = false;
  }
  
  //initialize the block with cordinate, is_hit set default to false
  public block(int x, int y) {
    is_moved = false;
    occupied = true;
    hit = false;
    miss = false;
    x_cor = x;
    y_cor = y;
  }
  
  //occupy the block, set occupied to true
  public int occupy_block() {
    if (occupied == true) {
      return -1;
    }
    occupied = true;
    return 0;
  }
  
  //return if the block is occupied
  public boolean is_occupied() {
    return occupied;
  }

  public boolean is_miss() {
    return miss;
  }
  //dig the block, make the hit to true
  public void dig_block() {
    if (occupied) {
      is_moved = false;//in case we hit the moved-hit part again
      hit = true;
    }
    else {
      miss = true;
    }
  }

  //clear the block
  public void clear_block(){
    occupied = false;
  }
  //return if the block is hit or not
  public boolean is_hit() {
    return hit;
  }
}
