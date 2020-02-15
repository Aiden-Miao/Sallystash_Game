package edu.duke.ece651.sallystash;

import java.util.ArrayList;

public class display {
  void display_myboard(board my_board) {
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
          System.out.println(i);
          System.out.println(j);
          myboard = myboard + my_board.getblock()[i][j].getstash().getcolor() + div_line;
        }
        else{
          myboard += " " + div_line;
        }
      }
      myboard += row + "\n";
    }
    myboard +=  "  0|1|2|3|4|5|6|7|8|9  \n";
    System.out.println(myboard);
  }
}
