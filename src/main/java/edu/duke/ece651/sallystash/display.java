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

  void display_board(String p1board)
  {
    System.out.println(p1board);
  }
  
  String draw_wholeboard(board my_board, board opp_board) {
    String wholeboard = "  0|1|2|3|4|5|6|7|8|9  ";
    String blank = "                ";
    wholeboard += blank;
    wholeboard += "  0|1|2|3|4|5|6|7|8|9  \n";
    assert (my_board.get_height() == opp_board.get_height());
    for (int i = 0; i < opp_board.get_height(); i++) {
      char row = (char)(i + 65);
      //begining of a line A + " ";
      wholeboard += row + " ";
      //draw myboard's part:
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
            wholeboard = wholeboard + "*" + div_line;
          }
          else {
            assert(my_board.getblock()[i][j].getstash() != null);
            wholeboard = wholeboard + my_board.getblock()[i][j].getstash().getcolor() + div_line;
          }
        }
        else{
          wholeboard += " " + div_line;
        }
      }
      wholeboard += row;

      //add blank part between 2 boards
      wholeboard += blank;
      
      //draw opponents's part:
      wholeboard += row + " ";
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
        //for ver2: we add a miss to block
        //if it's a hit, it's definetly hit
        //after check hit, we then check miss
        //because we may rehit the block again
        //so in the second board, it has nothing to do with is_occupied
        if(opp_board.getblock()[i][j].is_hit()){
          // if (opp_board.getblock()[i][j].is_occupied()) {
            //oppboard = oppboard + "*" + div_line;
          if (opp_board.getblock()[i][j].is_move()) {
            wholeboard += " " + div_line;
          }
          else {
            wholeboard = wholeboard + opp_board.getblock()[i][j].getstash().getcolor() + div_line;
          }
          // }
          //else {
        }
        else if(opp_board.getblock()[i][j].is_miss()){
            wholeboard = wholeboard + "X" + div_line;
            // }
        }
        //if it's not dug, then we should show it empty
        else{
          wholeboard += " " + div_line;
        }
      }
      wholeboard += row + "\n";
    }
    wholeboard +=  "  0|1|2|3|4|5|6|7|8|9  ";
    wholeboard += blank;
    wholeboard +=  "  0|1|2|3|4|5|6|7|8|9  \n";
    //System.out.println(myboard);
    return wholeboard;
  }

  /*
  void display_bothboard(String myboard, String Urboard) {
    String s1 = myboard.substring(0, myboard.indexOf("\n") - 1) + Urboard.substring(0, Urboard.indexOf("\n"));
    System.out.println(s1);
  }
  */
}
