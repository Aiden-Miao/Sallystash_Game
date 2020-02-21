package edu.duke.ece651.sallystash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class gameTest {
  @Test
  public void test_() {
    String s = "";
    s += "0000\nz0v\nt0p\na0v\nm4h\nb2v\nf2v\nt0h\ng6v\no6h\no0h\na8v\nk0h\n";
    s += "t0h\nt2h\nt4h\nt7h\ns0h\na0h\nb0h\nc0h\ne0h\ng0h\n";
    s += "0000\nzz\ntz\na0\na0\nb0\nb0\nb2\nb2\nc2\nc2\nd2\nd2\na8\na8\nb8\nb8\nc8\nc8\nd8\nd8\ne8\ne8\nf8\nf8\nf2\nf2\ng2\ng2\nh2\nh2\ng6\ng6\nh6\nh6\n0000\nzz\ni6\ni6\nj6\nj6\nk0\nk0\nk1\nk1\nk2\nk2\nk3\nk3\nk4\nk4\nk5\nk5\nm4\nm4\nm5\nm5\no0\no0\no1\no1\no2\no2\no3\no3\np6\no6\no7\no7\no8\no8\no9\no9\nt0\nt0\nt1\nt1\nt2\nt2\n";
    game mygame = new game(20, 10, s);
    mygame.playgame();
  }

}
