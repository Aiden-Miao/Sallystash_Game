package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class player {
  private board playboard;
  //private ArrayList<stash> mystash;
  private int sonar_action;
  private int move_action;
  private String name;
  public player(int h, int w, String myname) {
    playboard = new board(h, w);
    sonar_action = 1;
    move_action = 3;
    name = myname;
  }

  public String getname() {
    return name;
  }
  
  public void use_sonar() {
    sonar_action = sonar_action - 1;
  }
  
  public void use_move() {
    move_action = move_action - 1;
  }

  public int move_remaining() {
    return move_action;
  }

  public int sonar_remaining() {
    return sonar_action;
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
    };
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

  public int find(int x, int y, board myboard) {
    if ((x < 0 || x >= myboard.get_height())|| y < 0 || y >=myboard.get_width()){
      System.out.println("You dig a invalid position, dig again!\n");
      return -1;
    }
    //if the place have stash or not
    if (!myboard.getblock()[x][y].is_occupied()) {
      System.out.println("There's no stash here to move, choose a right place!\n");
      return -1;
    }
    //clear the block within the stash, but we can still get the color from the stash
    myboard.find_stash(x, y);
    return 0;
  }

  //record all thr marks all the hit block
  public ArrayList<Integer> find_allhits(int x, int y , board myboard) {
    ArrayList<Integer> hitlist = new ArrayList<Integer>();
    stash my_stash = myboard.getblock()[x][y].getstash();
    for (int i = 0; i < myboard.get_height(); i++) {
      for (int j = 0; j < myboard.get_width(); j++) {
        //make sure it's our stash's block
        if (myboard.getblock()[i][j].getstash() == my_stash) {
          if (myboard.getblock()[i][j].is_hit()) {
            //get the relative cor of beginning block
            
            //int[] begincor = my_stash.get_begincor();
            //int[] temp = {i - begincor[0], j - begincor[1]};
            int block_mark = myboard.getblock()[i][j].get_mark();
            System.out.printf("!!!!!The mark of block is:%d\n",block_mark);
            hitlist.add(block_mark);
          }
        }
      }
    }
    return hitlist;
  }

  public int sonar(int x, int y) {
    
    return 0;
  }
    
  public board getboard() {
    return playboard;
  }
  
  
}
