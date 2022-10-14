package listAndArrays;

import java.util.Arrays;

public class LexicographicOrder {
    
// Java Program to Sort Elements in
// Lexicographical Order (Dictionary Order)
  
  
    // this method sort the string array lexicographically.
    public static void
    sortLexicographically(String strArr[])
    {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i].compareToIgnoreCase(strArr[j])
                    > 0) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
    }
  
    // this function prints the array passed as argument
    public static void printArray(String strArr[])
    {
        for (String string : strArr)
            System.out.print(string + " ");
        System.out.println();
    }
  
    public static void main(String[] args)
    {
        // Initializing String array.
        //String stringArray[] = { "Harit",    "Girish", "Gritav", "Lovenish", "Nikhil", "Harman" };
  
        String stringArray[]
            = { "75",    "7", "8", "1", "2"};
  
        printArray(stringArray);
        
        // sorting String array lexicographically.
        sortLexicographically(stringArray);

        //Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);

        // printing String array after sorting.
        printArray(stringArray);
    }

}
