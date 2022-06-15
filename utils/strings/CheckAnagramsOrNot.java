package strings;

import java.util.Arrays;

public class CheckAnagramsOrNot {

  public static void main(String[] args) {
    String str1 = "dealer";
    String str2 = "leader";
    boolean b = areAnagrams(str1, str2);
    if (b == true) {
      System.out.println("it is a Anagran");
    } else {
      System.out.println("It is a not anagarms");
    }
  }

  public static boolean areAnagrams(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    str1 = str1.toUpperCase();
    str2 = str2.toUpperCase();

    char[] chrArray1 = str1.toCharArray();
    char[] chrArray2 = str2.toCharArray();
    Arrays.sort(chrArray1);
    Arrays.sort(chrArray2);

    return Arrays.equals(chrArray1, chrArray2);
  }
}
