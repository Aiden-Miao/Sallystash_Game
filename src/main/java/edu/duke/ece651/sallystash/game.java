package edu.duke.ece651.sallystash;

import java.util.ArrayList;
import java.util.Scanner;


public class game {
  private player A;
  private player B;
  //private int sonar_action;
  //private int move_action;
  public game(int h, int w) {
    A = new player(h, w,"A");
    B = new player(h, w,"B");
  }

  public void print_allstack() {
    String greenstack = "Green stacks that";
    String purplestack = "Purple stacks that";
    String redstack = "Red stacks that";
    String bluestack = "Blue stacks that";
    System.out.println("2    "+greenstack+"    1x2\n");
    System.out.println("3    "+purplestack+"    1x3\n");
    System.out.println("3    "+redstack+"    1x4\n");
    System.out.println("3    "+bluestack+"    1x6\n");
  }

  public void print_promt(String player_name, String number_of_stack, String color) {
    System.out.println("Player " + player_name + ", where do you want to place the " + number_of_stack + " " + color + " stack?");
  }
    
  void playgame() {
    //initialize stash for A
    stash A_G1 = new stash('G');
    stash A_G2 = new stash('G');
    stash A_P1 = new stash('P');
    stash A_P2 = new stash('P');
    stash A_P3 = new stash('P');
    stash A_R1 = new stash('R');
    stash A_R2 = new stash('R');
    stash A_R3 = new stash('R');
    stash A_B1 = new stash('B');
    stash A_B2 = new stash('B');
    stash A_B3 = new stash('B');
    //intialize stash for B
    stash B_G1 = new stash('G');
    stash B_G2 = new stash('G');
    stash B_P1 = new stash('P');
    stash B_P2 = new stash('P');
    stash B_P3 = new stash('P');
    stash B_R1 = new stash('R');
    stash B_R2 = new stash('R');
    stash B_R3 = new stash('R');
    stash B_B1 = new stash('B');
    stash B_B2 = new stash('B');
    stash B_B3 = new stash('B');
    //player A place stash
    System.out.println(
        "Player A, you are going place sally's stash on the board, Make sure Player B isn't looking! For each stach, type the cordinate of the upper left side of the stash, followed by either H(for horizontal) or V(for vertical). For example, M4H would place a stack horizontally starting at M4 and going to the right. You have\n");
    //print all stacks
    print_allstack();
    /*
    print_promt("A", "first", "Green");
    player_place_stash(A, A_G1, null);
    print_promt("A", "second", "Green");
    player_place_stash(A, A_G2, null);
    print_promt("A", "first", "Purple");
    player_place_stash(A, A_P1, null);
    print_promt("A", "second", "Purple");
    player_place_stash(A, A_P2, null);
    print_promt("A", "third", "Purple");
    player_place_stash(A, A_P3, null);      
    print_promt("A", "first", "Red");
    player_place_stash(A, A_R1, null);
    print_promt("A", "second", "Red");
    player_place_stash(A, A_R2, null);
    print_promt("A", "third", "Red");
    player_place_stash(A, A_R3, null);
    
    print_promt("A", "first", "Blue");
    player_place_stash(A, A_B1, null);
    print_promt("A", "second", "Blue");
    player_place_stash(A, A_B2, null);
    */    
    print_promt("A", "third", "Blue");
    player_place_stash(A, A_B3, null);
    
    //player B place stash
    /*
    print_promt("B", "first", "Green");
    player_place_stash(B, B_G1, null);
    print_promt("B", "second", "Green");
    player_place_stash(B, B_G2, null);
    print_promt("B", "first", "Purple");
    player_place_stash(B, B_P1, null);
    print_promt("B", "second", "Purple");
    player_place_stash(B, B_P2, null);
    print_promt("B", "third", "Purple");
    player_place_stash(B, B_P3, null);
        
    print_promt("B", "first", "Red");
    player_place_stash(B, B_R1, null);
    print_promt("B", "second", "Red");
    player_place_stash(B, B_R2, null);
    print_promt("B", "third", "Red");
    player_place_stash(B, B_R3, null);
        
    print_promt("B", "first", "Blue");
    player_place_stash(B, B_B1, null);
    print_promt("B", "second", "Blue");
    player_place_stash(B, B_B2, null);
    */    
    print_promt("B", "third", "Blue");
    player_place_stash(B, B_B3, null);
        
    while (true) {
      my_action(A, B);
      if (all_been_dig(B)==0) {
        System.out.println("Player A wins, congratulation!\n");
        break;
      }
      my_action(B, A);
      if (all_been_dig(A)==0) {
        System.out.println("Player B wins, congratulation!\n");
        break;
      }
    }
    //get the instruction from player after placing all the stash
    /*
    String instr;
    Scanner sc = new Scanner(System.in);
    instr = sc.nextLine();
    instr.toUpperCase();
    
    while(true){
      System.out.println("Possible actions for Player A:\n\n");
      System.out.println("D dig in a square\n");
      System.out.println("M move a stack to another square "+"("+);//need to change the structure here!!!!
      instr = sc.nextLine();
      instr.toUpperCase();   
      switch(instr){
      default: {
        System.out.println("Invalid instruction, please input again!\n");
        continue;
      }
      case"D":{
      display disp = new display();
      split_line();
      System.out.println("Player A's turn:\n");
      System.out.println("     Your tree" + "                              " + "Player B's tree\n");
      disp.display_board(disp.draw_wholeboard(A.getboard(), B.getboard()));
      split_line();
      System.out.println("Player A, it's your turn to guess!\n");
      guess(B);
      //if all of B's stashed are dug, then A wins
      if (all_been_dig(B) == 0) {
        System.out.println("Player A wins, congratulation!\n");
        break;
      }
      split_line();
      System.out.println("Player B's turn:\n");
      System.out.println("     Your tree" + "                              " + "Player A's tree\n");
      disp.display_board(disp.draw_wholeboard(B.getboard(), A.getboard()));
      split_line();
      System.out.println("Player B, it's your turn to guess!\n");
      guess(A);
      //if all A's stash are dug, then B wins
      if (all_been_dig(A) == 0) {
        System.out.println("Player B wins, congratulation!\n");
        break;
      }
      continue;
      }
      }
    */    
      /*
      while (true) {
        System.out.println("Start testing!!!!!!\n");
        System.out.println("Move A:\n");
        move_stash(A);
        disp.display_board(disp.draw_wholeboard(A.getboard(), B.getboard()));
        disp.display_board(disp.draw_wholeboard(B.getboard(), A.getboard()));
        System.out.println("Move B:\n");
        move_stash(B);
        disp.display_board(disp.draw_wholeboard(B.getboard(), A.getboard()));
        disp.display_board(disp.draw_wholeboard(A.getboard(), B.getboard()));
        System.out.println("Finish testing!\n");
      }
      */
    //}

  }

  //if all the stash has been dug
  public int all_been_dig(player P) {
    board b = P.getboard();
    for (int i = 0; i < b.get_height(); i++) {
      for (int j = 0; j < b.get_width(); j++) {
        //if any occupied block is not hit, then
        //game continues
        if (b.getblock()[i][j].is_occupied()) {
          if (!b.getblock()[i][j].is_hit()) {
            return -1;
          }
        }
      }
    }
    //if all of the occupied block is hit, then player wins
    return 0;
  }

  public void split_line() {
    for (int i = 0; i < 65; i++) {
      System.out.printf("-");
      if (i == 64) {
        System.out.println("\n");
      }
    }
  }
  
  public void guess(player P) {
    String s;
    Scanner sc = new Scanner(System.in);
    boolean validinput = false;
    while (!validinput) {
      s = sc.nextLine();
      s = s.toUpperCase();
      //System.out.println(s);
      if (s.length() != 2) {
        validinput = false;
        System.out.println("Invalid input length!\n");
        continue;
      }
      if (s.charAt(0) < 65 || s.charAt(0) > 90) {
        validinput = false;
        System.out.println("Invalid row!\n");
        continue;
      }
      if (s.charAt(1) < 48 || s.charAt(1) > 57) {
        validinput = false;
        System.out.println("Invalid column!\n");
        continue;
      }
      char[] parameter = s.toCharArray();
      int[] cor = new int[2];
      cor[0] = (int) parameter[0] - 65;
      //System.out.println(cor[0]);
      cor[1] = (int) parameter[1] - 48;
      P.dig(cor[0], cor[1], P.getboard());
      validinput = true;
    }
  }
    
  public void player_place_stash(player P, stash sh, ArrayList<Integer> hitlist){
    String s;
    Scanner sc = new Scanner(System.in);
    boolean validinput = false;
    while (!validinput) {
      s = sc.nextLine();
      s = s.toUpperCase();
      //System.out.println(s);
      if (s.length() != 3) {
        validinput = false;
        System.out.println("Invalid input length!\n");
        continue;
      }
      if (s.charAt(0) < 65 || s.charAt(0) > 90) {
        validinput = false;
        System.out.println("Invalid row!\n");
        continue;
      }
      if (s.charAt(1) < 48 || s.charAt(1) > 57) {
        validinput = false;
        System.out.println("Invalid column!\n");
        continue;
      }
      if((s.charAt(2) != 'H')&&(s.charAt(2) != 'V')&&(s.charAt(2)!='U')&&(s.charAt(2)!='D'&&(s.charAt(2)!='L')&&(s.charAt(2)!='R'))) {
        validinput = false;
        System.out.println("Invalid direction!\n");
        continue;
      }
      char[] parameter = s.toCharArray();
      int[] cor = new int[2];
      cor[0] = (int) parameter[0] - 65;
      cor[1] = (int) parameter[1] - 48;
      if (P.put_stash(cor, parameter[2], sh) == -1) {
        validinput = false;
        continue;
      }
      
      //add direction into stash
      sh.add_direct(parameter[2]);

      //place success
      System.out.println("place stash successfully!\n");
      validinput = true;

      //if the hitlist is not empty
      if (hitlist!=null) {
      for (int i = 0; i < hitlist.size(); i++) {
        //get the mark of hit block
        int mark = hitlist.get(i);
        
        //get the after relative cordinate
        //we pass in the block mark and the direction, so that we know the block's relative cordinate after moving, then we mark this block as move_hit
        int diff_cor[] = sh.getdiff_cor(mark, parameter[2]);
        //mark the hit block as moved
        int diff_x = diff_cor[0];
        int diff_y = diff_cor[1];
        P.getboard().getblock()[cor[0]+diff_x][cor[1]+diff_y].move_hit_block();
        //P.getboard().getblock()[cor[0]+diff_x][cor[1]+diff_y].dig_block();
      }
    }
    }
    
    display disp = new display();
    disp.display_board(disp.draw_myboard(P.getboard()));
    //    sc.close();
  }
  
  //in move stash, we treat it like 2 steps:
  //1. we find all the block that needs move, and mark them as unoccupied;
  //2. get the stash info from block, then we put new stash on the other place
  public void move_stash(player P){
    System.out.println("Which stash do you want to move?\n");
    String s;
    Scanner sc = new Scanner(System.in);
    boolean validinput = false;
    while (!validinput) {
      s = sc.nextLine();
      s = s.toUpperCase();
      if (s.length() != 2) {
        validinput = false;
        System.out.println("Invalid input length!\n");
        continue;
      }
      if (s.charAt(0) < 65 || s.charAt(0) > 90) {
        validinput = false;
        //char s1 = s.charAt(0);
        System.out.println("Invalid row!\n");
        continue;
      }
      if (s.charAt(1) < 48 || s.charAt(1) > 57) {
        validinput = false;
        System.out.println("Invalid column!\n");
        continue;
      }
      char[] parameter = s.toCharArray();
      int[] cor = new int[2];
      cor[0] = (int) parameter[0] - 65;
      cor[1] = (int) parameter[1] - 48;
      ArrayList<Integer> allhits_mark = new ArrayList<Integer>();
      if (P.find(cor[0], cor[1], P.getboard()) == -1) {
        validinput = false;
        continue;
      }
      
      //we only record all the hitted-block's mark, then we deal with it in place_stash
      allhits_mark = P.find_allhits(cor[0], cor[1], P.getboard());
      char new_color = P.getboard().getblock()[cor[0]][cor[1]].getstash().getcolor();
      stash new_stash = new stash(new_color);
      System.out.println("So, where do you want to move your stash to?\n");
      player_place_stash(P, new_stash, allhits_mark);
      validinput = true;
    }
  }

  public void my_action(player P, player opp){
    String instr;
    Scanner sc = new Scanner(System.in);
    //if there is any instr being excecuted
    boolean instr_exec = false;
    while (!instr_exec) {
      System.out.println("Possible actions for Player "+P.getname()+":\n\n");
      System.out.println("D dig in a square\n");
      System.out.println("M move a stack to another square "+"("+ P.move_remaining()+" remaining)\n");
      System.out.println("S sonar scan " + "(" + P.sonar_remaining() + " remaining)\n");
      System.out.println("Player " + P.getname() + ", what would you like to do?\n");
      instr = sc.nextLine();
      instr = instr.toUpperCase();
      //char instr = raw_instr.charAt(0);
      display disp = new display();
      switch (instr) {
      case "D":{
        split_line();
        System.out.println("Player "+P.getname()+"'s turn:\n");
        System.out.println("     Your tree" + "                              " + "Player "+opp.getname()+"'s tree\n");
        disp.display_board(disp.draw_wholeboard(P.getboard(), opp.getboard()));
        split_line();
        System.out.println("Player "+P.getname()+", it's your turn to guess!\n");
        guess(opp);
        instr_exec = true;
        break;
        }
      case"M":{
        //move stash
        //we show the two board's for player
        System.out.println("Player " + P.getname() + ", ready to move stash:\n");
        System.out.println("     Your tree" + "                              " + "Player "+opp.getname()+"'s tree\n");
        disp.display_board(disp.draw_wholeboard(P.getboard(), opp.getboard()));
        move_stash(P);
        instr_exec = true;
        break;
      }
      default:{
        System.out.println("invalid instruction, please input again!\n");
        break;
      }
      }
    }
  }
  
  
  public static void main(String[] args) {
    game mygame = new game(20, 10);
    mygame.playgame();
  }
}
