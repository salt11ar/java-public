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

import java.lang.*;
import java.io.*;
import java.util.*;


public class BinaryGap {

  static public int solution(int N)
  {
    int n=N;
    int maxGap = 0;
    int ipos = 1;
    int ngap= 0;

    System.out.println("input integer: "+ n);
    //convert to binary 
    String str = Integer.toBinaryString(n);
    System.out.println("input string: "+ str);
    int strlen = str.length();
    System.out.println("input strlen: "+ strlen);

    //find first 1 
    int firstIndex = str.indexOf('1')+1;
    System.out.println("1st i: "+ firstIndex);
    System.out.println("1st char: "+ str.charAt(ipos-1));
    ipos = firstIndex+1;
    
    System.out.println("start external loop... ");
    while (ipos < strlen  )
    {
      ngap=0; //reset counter for next gap loop
      System.out.println("start internal loop... ");
        while ( ipos <= strlen )
        {
          if(str.charAt(ipos-1) == '0' )
          {
          System.out.println("ipos: "+ ipos);
          System.out.println("char: "+ str.charAt(ipos-1));
          ipos++;
          ngap++;
          }
          else break;
        }
        System.out.println("break on loop for ceros, pos :"+ ipos);
        if(ipos > strlen)  
        {
          System.out.println("breaking..." );
          break;
        }
        if (str.charAt(ipos-1) =='1')
        {
          System.out.println("gap valid, cause found a 1 at pos: " +ipos);
          if(ngap>maxGap )
          {
            System.out.println("new maxgap, previous: "+ maxGap+ " new: "+ ngap);
            maxGap = ngap;
          }
        }
        else
        {
          System.out.println("not 1. raise exception breaking..." );
          break;
        }
        
        //ṕerf improvement
        //seek to next 1 before a cero 
        //i = str.indexOf('0');

        ipos++;

    }
    return maxGap; 

  }



  public static void main(String[] args) {

    int n; 

    //max 2,147,483,647
    
    
    n=32; //  result 0 
    n=529;  // result 4 
    n=20; // result 1  
    n=500; // result 1  
    n=1265; // result 1 
    int nResult = solution(n);
    System.out.println("Result: " + nResult);

    }
   
}





