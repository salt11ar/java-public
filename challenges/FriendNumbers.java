/**
 * FriendNumbers are two numbers that the sum of the divisors of them are equal to the other number
 */

public class FriendNumbers {
    
    public static void main(String[] args) {
    
        //System.out.println(divisor(220));
        //System.out.println(divisor(284));
        friends(220, 284);
    }

    /**
     * 
     * @param a
     * @param b
     * @return true if they are friends
     */
    public static Boolean friends(int a, int b ){
        
        if (divisor(a) == b && divisor(b)== a){
            System.out.println("True");
            return true;
        }
        else{
            System.out.println("False");
            return false;
        }

    }

    /**
     * Get the sum of divisors of a number
     * @param number
     * @return
     */
    public static int divisor(int number){

        int sum = 0;
        for(int i=1; i<number; i++){
        
            if(number%i == 0){
                sum = sum + i;
            }
        }    

        return sum;
    }

    
}
