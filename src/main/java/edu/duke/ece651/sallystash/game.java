package edu.duke.ece651.sallystash;

import java.util.ArrayList;
import java.util.Scanner;


public class game {
  private player A;
  private player B;

  public game(int h, int w) {
    A = new player(h, w);
    B = new player(h, w);
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
    System.out.println("Player A, where do you want to place the first Green Stack?\n");
    player_place_stash(A, A_G1, null);
    System.out.println("Player A, where do you want to place the second Green Stack?\n");
    player_place_stash(A, A_G2, null);
    System.out.println("Player A, where do you want to place the first Purple Stack?\n");
    player_place_stash(A, A_P1, null);
    System.out.println("Player A, where do you want to place the second Purple Stack?\n");
    player_place_stash(A, A_P2, null);
    System.out.println("Player A, where do you want to place the third Purple Stack?\n");
    player_place_stash(A, A_P3, null);
    System.out.println("Player A, where do you want to place the first Red Stack?\n");
    player_place_stash(A, A_R1, null);
    System.out.println("Player A, where do you want to place the second Red Stack?\n");
    player_place_stash(A, A_R2, null);
    System.out.println("Player A, where do you want to place the third Red Stack?\n");
    player_place_stash(A, A_R3, null);
    System.out.println("Player A, where do you want to place the first Blue Stack?\n");
    player_place_stash(A, A_B1, null);
    System.out.println("Player A, where do you want to place the second Blue Stack?\n");
    player_place_stash(A, A_B2, null);
    System.out.println("Player A, where do you want to place the second Blue Stack?\n");
    player_place_stash(A, A_B3, null);
    
    //player B place stash
    System.out.println("Player B, where do you want to place the first Green Stack?\n");
    player_place_stash(B, B_G1, null);
    System.out.println("Player B, where do you want to place the second Green Stack?\n");
    player_place_stash(B, B_G2, null);
    System.out.println("Player B, where do you want to place the first Purple Stack?\n");
    player_place_stash(B, B_P1, null);
    System.out.println("Player B, where do you want to place the second Purple Stack?\n");
    player_place_stash(B, B_P2, null);
    System.out.println("Player B, where do you want to place the third Purple Stack?\n");
    player_place_stash(B, B_P3, null);
    System.out.println("Player B, where do you want to place the first Red Stack?\n");
    player_place_stash(B, B_R1, null);
    System.out.println("Player B, where do you want to place the second Red Stack?\n");
    player_place_stash(B, B_R2, null);
    System.out.println("Player B, where do you want to place the third Red Stack?\n");
    player_place_stash(B, B_R3, null);
    System.out.println("Player B, where do you want to place the first Blue Stack?\n");
    player_place_stash(B, B_B1, null);
    System.out.println("Player B, where do you want to place the second Blue Stack?\n");
    player_place_stash(B, B_B2, null);
    System.out.println("Player B, where do you want to place the second Blue Stack?\n");
    player_place_stash(B, B_B3, null);
    
    while(true){
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
    
  public void player_place_stash(player P, stash sh, ArrayList<int []> hitlist){
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
      //System.out.println(cor[0]);
      cor[1] = (int) parameter[1] - 48;
      //System.out.println(cor[1]);
      if (P.put_stash(cor, parameter[2], sh) == -1) {
        validinput = false;
        continue;
      }
      System.out.println("place stash successfully!\n");
      validinput = true;
    
    if (hitlist!=null) {
      for (int i = 0; i < hitlist.size(); i++) {
        int diff_x = hitlist.get(i)[0];
        int diff_y = hitlist.get(i)[1];
        P.getboard().getblock()[cor[0]+diff_x][cor[1]+diff_y].move_hit_block();
        P.getboard().getblock()[cor[0]+diff_x][cor[1]+diff_y].dig_block();
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
    String s;
    Scanner sc = new Scanner(System.in);
    boolean validinput = false;
    while (!validinput) {
      s = sc.nextLine();
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
      cor[1] = (int) parameter[1] - 48;
      ArrayList<int[]> allhits = new ArrayList<int[]>();
      if (P.find(cor[0], cor[1], P.getboard()) == -1) {
        validinput = false;
        continue;
      }
      //find all the hit_blocks, it stores the relative cordinate of all hitted block 
      allhits = P.find_allhits(cor[0], cor[1], P.getboard());
      char new_color = P.getboard().getblock()[cor[0]][cor[1]].getstash().getcolor();
      stash new_stash = new stash(new_color);
      System.out.println("So, where do you want to move your stash to?\n");
      player_place_stash(P, new_stash, allhits);
      validinput = true;
    }
  }
  
  
  public static void main(String[] args) {
    game mygame = new game(20, 10);
    mygame.playgame();
  }
}
