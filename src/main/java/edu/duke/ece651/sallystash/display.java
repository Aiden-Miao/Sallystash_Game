package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class display {
  String draw_myboard(board my_board) {
    String myboard = "  0|1|2|3|4|5|6|7|8|9  \n";
    for (int i = 0; i < my_board.get_height(); i++) {
      char row = (char)(i + 65);
      //begining of a line A + " ";
      myboard += row + " ";
      for (int j = 0; j < my_board.get_width(); j++) {
        //if it's in the middle, it should be like P + "|"
        //if it's the end, it should be like P + " "
        String div_line;
        if (j == 9) {
          div_line = " ";
        }
        else{
          div_line = "|";
        }
        //if it's occupied, mark the color
        if(my_board.getblock()[i][j].is_occupied()){
          //if it's hit. show the mark
          if (my_board.getblock()[i][j].is_hit()) {
            myboard = myboard + "*" + div_line;
          }
          else {
            myboard = myboard + my_board.getblock()[i][j].getstash().getcolor() + div_line;
          }
        }
        else{
          myboard += " " + div_line;
        }
      }
      myboard += row + "\n";
    }
    myboard +=  "  0|1|2|3|4|5|6|7|8|9  \n";
    //System.out.println(myboard);
    return myboard;
  }

  void display_myboard(String p1board)
  {
    System.out.println(p1board);
  }
  
  String draw_opponentboard(board opp_board) {
    String oppboard = "  0|1|2|3|4|5|6|7|8|9  \n";
    for (int i = 0; i < opp_board.get_height(); i++) {
      char row = (char)(i + 65);
      //begining of a line A + " ";
      oppboard += row + " ";
      for (int j = 0; j < opp_board.get_width(); j++) {
        //if it's in the middle, it should be like P + "|"
        //if it's the end, it should be like P + " "
        String div_line;
        if (j == 9) {
          div_line = " ";
        }
        else{
          div_line = "|";
        }
        //if it's been dug, see if it's a hit or misss
        if(opp_board.getblock()[i][j].is_hit()){
          if (opp_board.getblock()[i][j].is_occupied()) {
            //oppboard = oppboard + "*" + div_line;
            oppboard = oppboard + opp_board.getblock()[i][j].getstash().getcolor() + div_line;
          }
          else {
            oppboard = oppboard + "X" + div_line;
          }
        }
        //if it's not dug, then we should show it empty
        else{
          oppboard += " " + div_line;
        }
      }
      oppboard += row + "\n";
    }
    oppboard +=  "  0|1|2|3|4|5|6|7|8|9  \n";
    //System.out.println(myboard);
    return oppboard;
  }

  void display_bothboard(String myboard, String Urboard) {
    String s1 = myboard.substring(0, myboard.indexOf("\n") - 1) + Urboard.substring(0, Urboard.indexOf("\n"));
    System.out.println(s1);
  }
}
