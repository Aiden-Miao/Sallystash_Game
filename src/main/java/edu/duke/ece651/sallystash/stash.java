package edu.duke.ece651.sallystash;

import java.util.ArrayList;
import java.util.HashMap;

public class stash {
  //private string shape;
  private char color;
  private block beginblock;//the beginning of the block
  private ArrayList<block> allblock;//all the block inside our stash
  private int[] begincor;//the beginning cordinate
  private char direction;//the direction
  private HashMap <Character,ArrayList<int[]>> direct_cor_map;
  public stash(char col) {
    begincor = new int[2];
    color = col;
    //do we also need to initialize beginblock?
    //initialize blocklist
    allblock = new ArrayList<block>();
    direct_cor_map = new HashMap<Character, ArrayList<int[]>>();
    //set up the search cordinate map based on color
    set_map();
    //direction = '0';
  }

  public void set_map(){
    if (color == 'G') {
      ArrayList<int[]> g_h = new ArrayList<int[]>();
      //add (0,0) (0,1) to 'H'
      g_h.add(0, new int[] {0,0});
      g_h.add(1, new int[] {0,1});
      assert (direct_cor_map != null);
      direct_cor_map.put('H', g_h);
      
      //add (0,0) (1,0) to 'V'
      ArrayList<int[]> g_v = new ArrayList<int[]>();
      g_v.add(0, new int[] {0,0});
      g_v.add(1, new int[] {1,0});
      direct_cor_map.put('V', g_v);
    }
    else if(color == 'P') {
      ArrayList<int[]> p_h = new ArrayList<int[]>();
      //add (0,0)(0,1)(0,2) to 'H'
      p_h.add(0, new int[] {0,0});
      p_h.add(1, new int[] {0,1});
      p_h.add(2, new int[] {0,2});
      direct_cor_map.put('H', p_h);
      
      //add (0,0)(1,0)(2,0) to 'V'
      ArrayList<int[]> p_v = new ArrayList<int[]>();
      p_v.add(0, new int[] {0,0});
      p_v.add(1, new int[] {1,0});
      p_v.add(2, new int[] {2,0});
      direct_cor_map.put('V', p_v);
    }
    else if (color == 'R') {
      //add (0,0)(1,-1)(1,0)(1,1) to red_up
      ArrayList<int[]> r_u = new ArrayList<int[]>();
      r_u.add(0, new int[] {0,0});
      r_u.add(1, new int[] {1,-1});
      r_u.add(2, new int[] {1,0});
      r_u.add(3, new int[] {1,1});
      direct_cor_map.put('U', r_u);
      
      //add (1,1)(0,0)(1,0)(2,0) to red_right
      ArrayList<int[]> r_r = new ArrayList<int[]>();
      r_r.add(0, new int[] {1,1});
      r_r.add(1, new int[] {0,0});
      r_r.add(2, new int[] {1,0});
      r_r.add(3, new int[] {2,0});
      direct_cor_map.put('R', r_r);
      
      //add (1,1)(0,2)(0,1)(0,0) to red_down
      ArrayList<int[]> r_d = new ArrayList<int[]>();
      r_d.add(0, new int[] {1,1});
      r_d.add(1, new int[] {0,2});
      r_d.add(2, new int[] {0,1});
      r_d.add(3, new int[] {0,0});
      direct_cor_map.put('D', r_d);

      //add(1,-1)(2,0)(1,0)(0,0) to red_left
      ArrayList<int[]> r_l = new ArrayList<int[]>();
      r_l.add(0, new int[] {1,-1});
      r_l.add(1, new int[] {2,0});
      r_l.add(2, new int[] {1,0});
      r_l.add(3, new int[] {0,0});
      direct_cor_map.put('L', r_l);
    }

    else if (color == 'B') {
      //add (0,0)(1,0)(2,0)(2,1)(3,1)(4,1) to blue_up
      ArrayList<int[]> b_u = new ArrayList<int[]>();
      b_u.add(0, new int[] {0,0});
      b_u.add(1, new int[] {1,0});
      b_u.add(2, new int[] {2,0});
      b_u.add(3, new int[] {2,1});
      b_u.add(4, new int[] {3,1});
      b_u.add(5, new int[] {4,1});
      direct_cor_map.put('U', b_u);
      
      //add (0,0)(0,1)(0,2)(-1,2)(-1,3)(-1,4) to blue_right
      ArrayList<int[]> b_r = new ArrayList<int[]>();
      b_r.add(0, new int[] {0,0});
      b_r.add(1, new int[] {0,1});
      b_r.add(2, new int[] {0,2});
      b_r.add(3, new int[] {-1,2});
      b_r.add(4, new int[] {-1,3});
      b_r.add(5, new int[] {-1,4});
      direct_cor_map.put('R', b_r);
      
      //add (0,0)(1,0)(2,0)(2,-1)(3,-1)(4,-1) to blue_down
      ArrayList<int[]> b_d = new ArrayList<int[]>();
      b_d.add(0, new int[] {0,0});
      b_d.add(1, new int[] {1,0});
      b_d.add(2, new int[] {2,0});
      b_d.add(3, new int[] {2,-1});
      b_d.add(3, new int[] {3,-1});
      b_d.add(3, new int[] {4,-1});
      direct_cor_map.put('D', b_d);

      //add (0,0)(0,1)(0,2)(1,2)(1,3)(1,4) to blue_left
      ArrayList<int[]> b_l = new ArrayList<int[]>();
      b_l.add(0, new int[] {0,0});
      b_l.add(1, new int[] {0,1});
      b_l.add(2, new int[] {0,2});
      b_l.add(3, new int[] {1,2});
      b_l.add(3, new int[] {1,3});
      b_l.add(3, new int[] {1,4});
      direct_cor_map.put('L', b_l);
    }
  }
  
   //return the relative cordinate after moving
  public int[] getdiff_cor(int blc_mark, char dirct) {
    ArrayList<int[]> ans_list = direct_cor_map.get(dirct);
    System.out.println(color);
    System.out.printf("the mark of blc_mark is :%d\n", blc_mark);
    System.out.printf("the direction is :%c\n", dirct);
    int ans[] = ans_list.get(blc_mark);
    for(int [] ans2:ans_list){
    System.out.printf("The return x is:%d\n", ans2[0]);
    System.out.printf("The return y is:%d\n", ans2[1]);
    }
    return ans;
  }
  
  //add direction to stash
  public void add_direct(char dir) {
    direction = dir;
  }

  //after we set up arraylist of blocks, if the board found the block
  //cordinate is invalid, we need to set again, so we need to reset our blocks
  public void reset_blocks() {
    allblock = new ArrayList<block>();
  }

  public int[] get_begincor() {
    return begincor;
  }
  //place the stash, calculate the cor of each block based on the beginning block
  public int place_stash(int x, int y, char orient) {
    beginblock = new block(x, y);
    //get the begining cordinate
    begincor[0] = x;
    begincor[1] = y;
    assert(beginblock != null);//test
    assert(allblock != null);//test
    switch(orient){
      //Up
    case 'U': {
      switch (color) {
      case 'R': {
        allblock.add(beginblock);
        allblock.add(new block(x + 1, y - 1));
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 1, y + 1));
        break;
      }
      case 'B': {
        allblock.add(beginblock);
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
        allblock.add(new block(x + 1, y + 1));
        allblock.add(beginblock);
        allblock.add(new block(x + 1, y));
        allblock.add(new block(x + 2, y));
        break;
      }
      case 'B': {
        allblock.add(beginblock);
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
        allblock.add(new block(x + 1, y + 1));
        allblock.add(new block(x, y + 2));
        allblock.add(new block(x, y + 1));
        allblock.add(beginblock);
        break;
      }
      case 'B': {
        allblock.add(beginblock);
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
        allblock.add(new block(x + 1, y - 1));
        allblock.add(new block(x + 2, y));
        allblock.add(new block(x + 1, y));
        allblock.add(beginblock);
        break;
      }
      case 'B': {
        allblock.add(beginblock);
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
        allblock.add(beginblock);
        allblock.add(new block(x, y + 1));
        break;
      }
        //purple block 1x3
      case 'P': {
        allblock.add(beginblock);
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
        allblock.add(beginblock);
        allblock.add(new block(x + 1, y));
        break;
      }
        //purple block 1x3
      case 'P': {
        allblock.add(beginblock);
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
