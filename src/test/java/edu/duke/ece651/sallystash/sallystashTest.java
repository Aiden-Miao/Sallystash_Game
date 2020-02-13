package edu.duke.ece651.sallystash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class sallystashTest {
  @Test
  public void test_() {
    sallystash mygame = new sallystash(10, 20);
    mygame.draw_myboard();
  }

}
