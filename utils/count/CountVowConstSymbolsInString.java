package count;

import java.util.Scanner;

public class CountVowConstSymbolsInString {

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Enter any String");
      String x = input.nextLine();

      count(x);
    }
  }

  public static void count(String x) {
    x = x.toUpperCase();
    char[] y = x.toCharArray();
    int size = y.length;
    int i = 0, vowcont = 0, constcont = 0, splcont = 0;

    while (i != size) {
      if (y[i] >= 'A' && y[i] <= 'Z') {
        if (
          y[i] == 'A' ||
          y[i] == 'I' ||
          y[i] == 'O' ||
          y[i] == 'E' ||
          y[i] == 'U'
        ) {
          ++vowcont;
        } else {
          ++constcont;
        }
      } else {
        ++splcont;
      }
      ++i;
    }

    System.out.println(x);
    System.out.println("Vowles are :" + vowcont);
    System.out.println("Constants are :" + constcont);
    System.out.println("Special characters are :" + splcont);
  }
}
