/*
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
 */

public class FrogJmp {

    public static void main(String[] args) {

        System.out.println("-> " + test1());
         System.out.println("-> " + test2());
     /*    System.out.println("-> " + test3());
        System.out.println("-> " + test4());
 */
    }

    public int solution(int X, int Y, int D) {

        int distanceToJump = Y - X;
        int jumpsRequired = distanceToJump / D;
        if(distanceToJump % D != 0) {
            jumpsRequired++; //only add extra jump if remainder exists
        }

        return jumpsRequired;
    }

    public static boolean test1() {
        System.out.println("test input");
        
        if ( new FrogJmp().solution(10,85,30) == 3)
            return true;
        else
            return false;
    }

    public static boolean test2() {
        System.out.println("test input");
        
        if ( new FrogJmp().solution(3, 999111321, 7)  == 142730189)
            return true;
        else
            return false;
    }
}
