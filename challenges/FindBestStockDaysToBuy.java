import java.util.Scanner;


public class FindBestStockDaysToBuy {
   
    static int solution(int[] input_arr) {
        // your code goes here
        int minIndex = minValue(input_arr, 0);
        int maxIndex = maxValue(input_arr);
        
        if(  minIndex < maxIndex ) {
            return input_arr[maxIndex] - input_arr[minIndex];
        }
        else{
            minIndex = minValue(input_arr, input_arr[minIndex]);
            maxIndex = maxValue(input_arr); // ensure the max value is in the latest day
            if(  minIndex < maxIndex ) {
                return input_arr[maxIndex] - input_arr[minIndex];
            }
        }

        return 0;
    }

    public static int maxValue(int[] ar) {
		int maxValue = ar[0];
            
        int maxIndex = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] >= maxValue) {
				maxValue = ar[i];
                maxIndex = i; 
			}
		}
        return maxIndex;

		
	}

    /**
     * 
     * @param ar
     * @param fromthis if you want the min value starting at some value and not the first pos value
     * @return
     */
	public static int minValue(int[] ar, int fromthis) {
		int minValue= ar[0];
        
        int minIndex = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] < minValue && ar[i] > fromthis) {
				minValue = ar[i];
                minIndex = i;
			}
		}
        return minIndex;
		
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.nextLine();
        int[] input_arr = new int[n];

        String[] arrStr = scanner.nextLine().split(" ");
        scanner.close();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(arrStr[i]);
            input_arr[i] = x;
        }

        int result = solution(input_arr);

        System.out.println(result);
    }
}
