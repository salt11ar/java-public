import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import listAndArrays.ArrayUtils;
import listAndArrays.ListUtils;

/*
 * @author salt11ar
 *
 * Find duplicates in an array of integers
 */
public class FindDulicateNumbersInList {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        numbers.add(5);
        numbers.add(7);

        System.out.println("duplicate list is: " + numbers);
        List<Integer> duplicates = findDuplicatesInList(numbers);

        System.out.println("duplicate elements are:  " + duplicates);
        // System.out.println(duplicates.toString());

        /***
         * Now wiht an array converted to a list with a method
         */
        numbers.clear();
        duplicates.clear();

        int[] intArray = new int[] { 1, 2, 3, 4, 5, 1, 3, 5 };
        System.out.print("duplicate list is: [");
        for(int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
        System.out.println("]");

        duplicates = findDuplicatesInArray( intArray);
        System.out.println("duplicate elements are:  " + duplicates);

        /* Using utils */

        intArray = new int[] { 2,4,5,6,7,1,2,3 };
        System.out.print("again duplicate list is:");
        ArrayUtils.printArrayToConsole(intArray);
        System.out.println(" ");
        numbers = ListUtils.arrayToList(intArray);
        duplicates = findDuplicatesInList(numbers);
        System.out.println("duplicate elements are:  " + duplicates);

    }

    private static List<Integer> findDuplicatesInArray( int[] intArray) {
        List<Integer> duplicates;
        List<Integer> numbers = new ArrayList<Integer>();

        for (int element : intArray) {
            numbers.add(element);
        }
        duplicates = findDuplicatesInList(numbers);
        return duplicates;
    }

    public static List<Integer> findDuplicatesInList(List<Integer> list) {
        List<Integer> listWithoutDup = new ArrayList<Integer>();
        Set<Integer> duplicates = new HashSet<Integer>();

        for (Integer i : list) {
            if (listWithoutDup.contains(i)) {
                duplicates.add(i);
            } else {
                listWithoutDup.add(i);
            }
        }

        listWithoutDup.clear();
        listWithoutDup.addAll(duplicates);

        return listWithoutDup;
    }
}
