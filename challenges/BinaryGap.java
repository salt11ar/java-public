


import java.lang.*;
import java.io.*;
import java.util.*;

public class BinaryGap {

  static public int solution(int N)
  {
    int n=N;
    int maxGap = 0;
    int i = 0;
    int igap= 0;

    System.out.println("input integer: "+ n);
    //convert to binary 
    String str = Integer.toBinaryString(n);
    System.out.println("input string: "+ str);
    int strlen = str.length();
    System.out.println("input strlen: "+ strlen);

    //find first 1 

    int firstIndex = str.indexOf('1');
    System.out.println("1st i: "+ firstIndex);
    System.out.println("1st char: "+ str.charAt(i));
   
    i = firstIndex+1;

    while (i < strlen -1 )
    {
      igap=0; //reset for next gap loop
      System.out.println("start loop... ");

        while (str.charAt(i) == '0' )
        {
          System.out.println("i: "+ i);
          System.out.println("char: "+ str.charAt(i));
          i++;
          igap++;
          //System.out.println("igap: "+ igap);

          if(i > strlen-1)      
            break; //exit from cero detection if no more chars
          
        }

        System.out.println("break on loop for ceros, i:"+ i);

        if(i > strlen-1)  
        {
          System.out.println("breaking..." );
          break;
        }
        
        if (str.charAt(i) =='1')
        {
          System.out.println("gap valid, cause found a 1 at: " +i);
          if(igap>maxGap )
          {
            System.out.println("new maxgap, previous: "+ maxGap+ "new: "+ igap);
            maxGap = igap;
          }
       
        }
        else
        {
          System.out.println("not 1. breaking..." );
          break;
        }
        
        //ṕerf improvement
        //seek to next 1 before a cero 
        //i = str.indexOf('0');

        i++;

    }

    
    System.out.println("Result: " + nResult);
    return maxGap; 

  }



  public static void main(String[] args) {

    int n=529;  //max 2147483647
    int nResult = solution(n);
    System.out.println("Result: " + nResult);

    }
   
}


/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
*/



