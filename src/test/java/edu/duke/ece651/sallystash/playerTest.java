package edu.duke.ece651.sallystash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class playerTest {
  @Test
  public void test_() {
    stash G1 = new stash('G');
    stash G2 = new stash('G');
    stash B1 = new stash('B');
    player p1 = new player(20,10);
    int[] temp1 = {5,5};
    int[] temp2 = {6,6};
    p1.put_stash(temp1, 'H', B1);
    p1.put_stash(temp2, 'V', G2);
    display disp = new display();
    disp.display_myboard(p1.getboard());
  }

}
