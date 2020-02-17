package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class stash {
  //private string shape;
  private char color;
  private block beginblock;//the beginning of the block
  private ArrayList<block> allblock;//all the block inside our stash
  
  //initialize a stash
  public stash(char col) {
    color = col;
    //do we also need to initialize beginblock?
    //initialize blocklist
    allblock = new ArrayList<block>();
  }

  //after we set up arraylist of blocks, if the board found the block
  //cordinate is invalid, we need to set again, so we need to reset our blocks
  public void reset_blocks() {
    allblock = new ArrayList<block>();
  }

  //place the stash, calculate the cor of each block based on the beginning block
  public int place_stash(int x, int y, char orient) {
    beginblock = new block(x, y);
    assert(beginblock != null);//test
    assert(allblock != null);//test
    allblock.add(beginblock);
    switch(orient){
      //Up
    case 'U': {
      switch (color) {
      case 'R': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 1, y - 1));
        allblock.add(new block(x + 1, y + 1));
        break;
      }
      case 'B': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        allblock.add(new block(x + 2, y + 1));
        allblock.add(new block(x + 3, y + 1));
        allblock.add(new block(x + 4, y + 1));
        break;
      }
      default: {
        return -1;
      }
      }
      return 0;
    }
      //Right
    case 'R': {
      switch (color) {
      case 'R': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        allblock.add(new block(x + 1, y + 1));
        break;
      }
      case 'B': {
        allblock.add(new block(x, y + 1));
        allblock.add(new block(x, y + 2));
        allblock.add(new block(x - 1 , y + 2));
        allblock.add(new block(x - 1 , y + 3));
        allblock.add(new block(x - 1 , y + 4));
        break;
      }
      default:{
        return -1;
      }
      }
      return 0;
    }
      //Down
    case 'D': {
      switch (color) {
      case 'R': {
        allblock.add(new block(x, y + 1));
        allblock.add(new block(x, y + 2));
        allblock.add(new block(x + 1, y + 1));
        break;
      }
      case 'B': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        allblock.add(new block(x + 2 , y - 1));
        allblock.add(new block(x + 3 , y - 1));
        allblock.add(new block(x + 4 , y - 1));
        break;
      }
      default: {
        return -1;
      }
      }
      return 0;
    }
      //Left
    case 'L': {
      switch (color) {
      case 'R': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        allblock.add(new block(x + 1, y -1));
        break;
      }
      case 'B': {
        allblock.add(new block(x, y + 1));
        allblock.add(new block(x, y + 2));
        allblock.add(new block(x + 1 , y + 2));
        allblock.add(new block(x + 1 , y + 3));
        allblock.add(new block(x + 1 , y + 4));
        break;
      }
      default: {
        return -1;
      }
      }
      return 0;
    }
      //Herizon
    case 'H':{
      switch(color){
        //green block 1x2
      case 'G':{
        allblock.add(new block(x, y + 1));
        break;
      }
        //purple block 1x3
      case 'P': {
        allblock.add(new block(x, y + 1));
        allblock.add(new block(x, y + 2));
        break;
      }
      default: {
        return -1;
      }
      }
      return 0;
    }
    case 'V':{
      switch(color){
        //green block 1x2
      case 'G':{
        allblock.add(new block(x + 1, y));
        break;
      }
        //purple block 1x3
      case 'P': {
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        break;
      }
      default:{
        return -1;
      }
      }
      return 0;
      //break;
    }
    default: {
      return -1;
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
