package listAndArrays;

public class ArrayUtils {

    public static void printArrayToConsole(int[] intArray) {
        System.out.print("[");
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
        System.out.print("]");

    }

    public static int sumOfArray(int[] arr) {
        // getting sum of array values
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

}
