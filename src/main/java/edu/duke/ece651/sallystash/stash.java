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
      ArrayList<int[]> g_h_temp = new ArrayList<int[]>();
      int first[] = new int[2];
      int second[] = new int[2];
      //add (0,0) (0,1) to 'H'
      first[0] = 0;
      first[1] = 0;
      second[0] = 0;
      second[1] = 1;
      g_h_temp.add(0,first);
      g_h_temp.add(1,second);
      ArrayList<int[]> g_h = new ArrayList<int[]>(g_h_temp);
      assert (direct_cor_map != null);
      direct_cor_map.put('H', g_h);
      //add (0,0) (1,0) to 'V'
      ArrayList<int[]> g_v_temp = new ArrayList<int[]>();
      first[0] = 0;
      first[1] = 0;
      second[0] = 1;
      second[1] = 0;
      g_v_temp.add(0, first);
      g_v_temp.add(1, second);
      ArrayList<int[]> g_v = new ArrayList<int[]>(g_v_temp);
      direct_cor_map.put('V', g_v);
    }
    else if(color == 'P') {
      ArrayList<int[]> p_h_temp = new ArrayList<int[]>();
      int first[] = new int[2];
      int second[] = new int[2];
      int third[] = new int[2];
      //add (0,0)(0,1)(0,2) to 'H'
      first[0] = 0;
      first[1] = 0;
      second[0] = 0;
      second[1] = 1;
      third[0] = 0;
      third[1] = 2;
      p_h_temp.add(0,first);
      p_h_temp.add(1,second);
      p_h_temp.add(2, third);
      ArrayList<int[]> p_h = new ArrayList<int[]>(p_h_temp);
      direct_cor_map.put('H', p_h);
      //add (0,0)(1,0)(2,0) to 'V'
      ArrayList<int[]> p_v_temp = new ArrayList<int[]>();
      first[0] = 0;
      first[1] = 0;
      second[0] = 1;
      second[1] = 0;
      third[0] = 2;
      third[1] = 0;
      p_v_temp.add(0, first);
      p_v_temp.add(1, second);
      p_v_temp.add(2, third);
      ArrayList<int[]> p_v = new ArrayList<int[]>(p_v_temp);
      direct_cor_map.put('V', p_v);
    }
    else if (color == 'R') {
      //add (0,0)(1,-1)(1,0)(1,1) to red_up
      ArrayList<int[]> r_u = new ArrayList<int[]>();
      /*
      int first[] = new int[2];
      int second[] = new int[2];
      int third[] = new int[2];
      int fourth[] = new int[2];
      first[0] = 0;
      first[1] = 0;
      second[0] = 1;
      second[1] = -1;
      third[0] = 1;
      third[1] = 0;
      fourth[0] = 1;
      fourth[1] = 1;
      */
      r_u.add(0, new int[] {0,0});
      r_u.add(1, new int[] {1,-1});
      r_u.add(2, new int[] {1,0});
      r_u.add(3, new int[] {1,1});
      //System.out.println("put in UP");
      direct_cor_map.put('U', r_u);
      
      //add (1,1)(0,0)(1,0)(2,0) to red_right
      ArrayList<int[]> r_r_temp = new ArrayList<int[]>();
      first[0] = 1;
      first[1] = 1;
      second[0] = 0;
      second[1] = 0;
      third[0] = 1;
      third[1] = 0;
      fourth[0] = 2;
      fourth[1] = 0;
      r_r_temp.add(0,first);
      r_r_temp.add(1,second);
      r_r_temp.add(2, third);
      r_r_temp.add(3, fourth);
      //System.out.printf("The second x is:%d\n", r_r.get(1)[0]);
      //System.out.printf("The second y is:%d\n", r_r.get(1)[1]);
      //System.out.println("put in right");
      ArrayList<int[]> r_r = new ArrayList<int[]>(r_r_temp);
      direct_cor_map.put('R', r_r);
      //add (1,1)(0,2)(0,1)(0,0) to red_down
      ArrayList<int[]> r_d_temp = new ArrayList<int[]>();
      first[0] = 1;
      first[1] = 1;
      second[0] = 0;
      second[1] = 2;
      third[0] = 0;
      third[1] = 1;
      fourth[0] = 0;
      fourth[1] = 0;
      r_d_temp.add(0,first);
      r_d_temp.add(1,second);
      r_d_temp.add(2, third);
      r_d_temp.add(3, fourth);
      //System.out.println("put in down");
      ArrayList<int[]> r_d = new ArrayList<int[]>(r_d_temp);
      direct_cor_map.put('D', r_d);

      //add(1,-1)(2,0)(1,0)(0,0) to red_left
      ArrayList<int[]> r_l_temp = new ArrayList<int[]>();
      first[0] = 1;
      first[1] = -1;
      second[0] = 2;
      second[1] = 0;
      third[0] = 1;
      third[1] = 0;
      fourth[0] = 0;
      fourth[1] = 0;
      r_l_temp.add(0,first);
      r_l_temp.add(1,second);
      r_l_temp.add(2, third);
      r_l_temp.add(3, fourth);
      //System.out.println("put in left");
      ArrayList<int[]> r_l = new ArrayList<int[]>(r_l_temp);
      direct_cor_map.put('L', r_l);
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
