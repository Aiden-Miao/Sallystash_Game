package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class stash {
  //private string shape;
  private char color;
  private block beginblock;//the beginning of the block
  private ArrayList<block> allblock;//all the block inside
  
  //put a stash in here
  //add all the block into this stash
  public stash(char col) {
    color = col;
    //initialize blocklist
    allblock = new ArrayList<block>();
  }
  
  public void place_stash(int x, int y, char orient) {
    beginblock = new block(x, y);
    assert(beginblock != null);//test
    assert(allblock != null);//test
    allblock.add(beginblock);
    switch(orient){
    case 'H':{
      allblock.add(new block(x, y + 1));
      allblock.add(new block(x, y + 2));
      allblock.add(new block(x, y + 3));
      break;
    }
    case 'V':{
      allblock.add(new block(x + 1, y));
      allblock.add(new block(x + 2, y));
      allblock.add(new block(x + 3, y));
      break;
    }
    }
  }
   
  public ArrayList<block> getallblock() {
    return allblock;
  }

  public char getcolor() {
    return color;
  }
}
