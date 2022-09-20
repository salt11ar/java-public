/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation cr = new CyclicRotation();

        System.out.println("-> " + cr.test1());
        // System.out.println("-> "+ test2());
        // System.out.println("-> "+ test3());
        // System.out.println("-> "+ test4());

    }

    public int[] solution(int[] A, int K) {


        int[] array = A;

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        Collections.rotate(list, K); 

        int[] solu1 = new int[array.length];
    
        for (int i = 0; i < array.length; i++) {
            solu1[i] =  list.get(i);
        }

        // Option  with streams - not finished yet 
/* 
        int[] shiftedArray = new int[array.length];

        shiftedArray = Arrays.stream(array)
                                        .skip(K)
                                        .toArray();
 */
                                        

        //Option 2 with arraycopy

         //  Step 1
            // k > array length then we dont need to shift k times because when we shift
            // array length times then the array will go back to intial position.
            // so we can just do only k%array length times.
            // change k = k% array.length;
    
            if (K > array.length) {
                K = K % array.length;
            }
            
            //   Step 2;
            // initialize temporary array with same length of input array.
            // copy items from input array starting from array length -k as source till
            // array end and place in new array starting from index 0;
            int[] tempArray = new int[array.length];
    
            System.arraycopy(array, array.length - K, tempArray, 0, K);
            
            //   step3:
            // loop and copy all the remaining elements till array length -k index and copy
            // in result array starting from position k
            for (int i = 0; i < array.length - K; i++) {
                tempArray[K + i] = array[i];
            }
            
  //        return tempArray;            
        return solu1;

    }

    public boolean test1() {
        int[] thearray = new int[] { 3, 8, 9, 7, 6};
        int[] expected = new int[] { 9, 7, 6, 3, 8};
        System.out.println("test input");
        printArrayToConsole(thearray);
        System.out.println("K=" + 3);
        
        int[] solu = solution(thearray, 3);

        if (Arrays.equals(solu, expected))
            return true;
        else
            return false;
    }

    public static void printArrayToConsole(int[] intArray) {
        System.out.print("[");
        for (int i = 0; i < intArray.length; i++)
            System.out.print(
                    intArray[i] + " ");
        System.out.print("]");
        System.out.println();
    }
}
