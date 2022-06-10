package listAndArrays;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    
    public static List<Integer> arrayToList( int[] intArray) {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int element : intArray) {
            numbers.add(element);
        }
        return numbers;
    }
}
