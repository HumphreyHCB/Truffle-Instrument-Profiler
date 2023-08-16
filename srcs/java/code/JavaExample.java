package code;

import tool.Benchmark;
import java.util.Random;

public class JavaExample {
  public static void main(String[] args) {
    System.out.println("Hello");
    myprint();
  }

    public static void myprint() {
        System.out.println("Hello");
        System.out.println("This is my Print");
        testMaths();
        testMaths();
    }

    public static void testMaths() {
        int x = 7;
        int y = 12;
        Random rand = new Random();
        int z = x + y;
        System.out.println(z - rand.nextInt(5));
    }
    
}
