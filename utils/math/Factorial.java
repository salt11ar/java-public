package math;
import java.util.Scanner;

public class Factorial {

  public static void main(String[] args) {
    try {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter a number for factorial:  ");
      int num = s.nextInt();
      s.close();
      double fact = 1;
      int i;
      for (i = 1; i <= num; i++) {
        fact = fact * i;
      }

      System.out.println("factorial numner is " + fact);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
