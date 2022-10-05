/**
 * Compress algorithm when found same char n times it prints n+char instead 
 * ABBBC will return A3BC 
 */
import java.util.Scanner;

public class CompressDupsinString {
    static String solution(String s) {
        // your code goes here
        int i=0, count =0;
        StringBuilder sb = new StringBuilder();

        while(i <= s.length()-1 ){

            //check for the last position to not get charat a null position
            if (i == s.length()-1)
            {
                if(count==0){
                    sb.append(s.charAt(i));
                }
                else{
                    sb.append(count+1);
                    sb.append(s.charAt(i));
                    count =0;
                }
                i++;
                continue;

            }
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            else{
                if(count==0){
                    sb.append(s.charAt(i));
                }
                else{
                    sb.append(count+1);
                    sb.append(s.charAt(i));
                    count =0;
                }
            }
            i++;

            
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        scanner.close();

        String result = solution(s);

        System.out.println(result);

    }
}
