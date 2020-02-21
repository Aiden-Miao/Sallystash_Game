package edu.duke.ece651.sallystash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class gameTest {
  @Test
  public void test_() {
    game robotgame = new game(20, 10,"y\ny\n");
    robotgame.playgame();
    String instr = "";
    instr += "A\nN\nN\nabcd\nzp3\n003\nt9r\nt9u\nt9l\nt9d\nt9h\nt0h\nt2h\nt3h\nt4h\nt7h\ns0h\na0v\na0h\na9r\nd4u\ng1r\nk4u\np0h\no7u\na0h\na3v\na6h\nc1h\ne4h\nd2d\nj4u\nm5l\np4u\ng0r\nn0r\n";
    //    instr += "a0v\na1v\na2v\nj0v\na6h\nj0v\nj2r\nk4u\nn4d\nh4l\nb7u\nq2r\n";
    instr += "a0v\na1v\na2v\na3v\na6h\nd1l\nk4u\nn4d\nq2r\nh4d\nh4l\ns0b\ns0r\n";
    instr += "d\nd4\nd\nf2\nd\nr3\nd\na3\nm\ne4\na0l\naaaa\na0r\nm\nr3\naaaa\n7up\nmmp\nb7u\ns\ndddd\nd5\ns\n00\nt00\n6t\nd8\nd\na0\na\nd\na7\nd\na1\nm\ne0\nj2r\nd\na2\nm\na3\nj0v\nd\na3\nd\na3\nd\na4\nd\na4\nd\na7\nd\na7\nd\na6\nd\na6\nd\na8\nd\na8\nd\nb0\nd\nb0\nd\nb1\nd\nb1\nd\nb2\nd\nb2\nd\nc2\nd\nc2\nm\nb0\nd4u\nm\ns\nd\na8\nd\nh4\nd\nh4\nd\nh5\nd\nh5\nd\nh6\nd\nh6\nd\ni6\nd\ni6\nd\ni7\nd\ni7\nd\ni8\nd\ni8\nd\nb7\nd\nb7\nd\nc7\nd\nc7\nd\nd7\nd\nd7\nd\nd8\nd\nd8\nd\nf8\nd\nf8\nd\nj0\nd\nj0\nd\nk0\nd\nk0\nd\nl0\nd\nl0\nd\nj2\nd\nj2\nd\nk2\nd\nk2\nd\nl2\nd\nl2\nd\nk3\nd\nk3\nd\nl3\nd\nl3\nd\nk4\nd\nk4\nd\nl4\nd\nl4\nd\nl5\nd\nl5\nd\nn4\nd\nn4\nd\nn5\nd\nn5\nd\nn6\nd\nn6\nd\no5\nd\no5\nd\np4\nd\np4\nd\np5\nd\np5\nd\np6\nd\np6\nd\nq2\nd\nq2\nd\nq3\nd\nq3\nd\nz4\nd\nz4z\nz4\nd\nq4\n";
    game humangame = new game(20, 10, instr);
    humangame.playgame();
  }
}
