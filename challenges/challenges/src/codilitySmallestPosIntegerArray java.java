import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].


# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(A):
    # write your code in Python 3.6
    pass

// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
}


*/

 // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class codilitySmallestPosIntegerArray {


    public static void main(String[] args) {

        /* int[] i1 = new int[121];

        i1[0] = -1;
        i1[1] = -1;
        solution(i1); */

        System.out.println("-> "+ test1());
        System.out.println("-> "+ test2());
        System.out.println("-> "+ test3());
        System.out.println("-> "+ test4());
        
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        // optimize later for space and time?

        // solution design 1. order array  by sort
        // 2. get rid of duplicates, maybe send to a set or streams
        // 3. for each element see if it is the previous -1 if not it is the one 
        // 4. check negatives and boundaries if no gap found in the list 

        Comparator<Integer> byAsc = (Integer o1, Integer o2) -> o1.compareTo(o2);
        
        
        List<Integer> alist = new ArrayList<>();
        for (int val : A) {
            alist.add(val);
        }
        
        System.out.println("list w integers: " + alist);
        
        alist.sort(byAsc);
        alist = alist.stream()
                .distinct()
                .collect(Collectors.toList());         

        System.out.println("list distinct and ordered:" + alist);

        
        boolean foundgap=false;
        //follow list from start 
        for (int i = 0; i < alist.size()-1; i++){

            System.out.println("i= "+alist.get(i)+ ", i+1= "+ alist.get(i+1));

            if ( (alist.get(i) > 0 ) && 
                    (alist.get(i+1) - alist.get(i) != 1 )
                     ) // i and i+1 should be +1 in the value
            {
                    System.out.println("gap");
                    foundgap = true;
                    return alist.get(i).intValue()+1;
            }
        }

        int lastelem = alist.get(alist.size()-1);
        
        if(foundgap == false)
        {   if(lastelem < 0)
                return 1;            
            else
                return lastelem + 1;
        }

        return 1;
        
    }

    // Doing tests like this for pages like codility that don't support junit so easy
    public static boolean test1()
    {
        int[] thearray= new int[]{1, 3, 6, 4, 1, 2};
        System.out.println("test input" );
        printArrayToConsole(thearray); 
        
        
        if (solution(thearray) == 5) 
            return true;
        else
            return false;
    }

    public static boolean test2()
    {
        int[] thearray= new int[]{1, 2, 3};
        System.out.println("test input" );
        printArrayToConsole(thearray); 
        
        
        if (solution(thearray) == 4) 
            return true;
        else
            return false;
    }

    public static boolean test3()
    {
        int[] thearray= new int[]{Integer.valueOf(-1), Integer.valueOf(-3)};
        System.out.println("test input" );
        printArrayToConsole(thearray); 
        
        if (solution(thearray) == 1) 
            return true;
        else
            return false;
    }

    public static boolean test4()
    {
        int[] thearray= new int[]{1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,20};
        System.out.println("test input" );
        printArrayToConsole(thearray); 
        
        
        if (solution(thearray) == 15) 
            return true;
        else
            return false;
    }
    
    public static void printArrayToConsole(int[] intArray) {
        System.out.print("[");
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
        System.out.print("]");
        System.out.println();

    }
}
