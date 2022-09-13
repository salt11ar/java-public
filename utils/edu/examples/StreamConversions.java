package edu.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * A simple Java Program to convert streams to collections
 * in Java.
 */
public class StreamConversions {

     public static void main(String[] args) {

          // Stream of Integers
          List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 78, 9, 10, 3, 2, 34, 5, 3);

          // 1. Stream to List
          List<Integer> listOfIntegers = input.stream()
                    .collect(Collectors.toList());
          System.out.println("Stream to List: " + listOfIntegers);

          // Stream to ArrayList
          ArrayList<Integer> aList = input.stream()
                    .collect(Collectors.toCollection(ArrayList::new));
          System.out.println("Stream to ArrayList: " + aList);

          // Stream to LinkedList
          LinkedList<Integer> linkedList = input.stream()
                    .collect(Collectors.toCollection(LinkedList::new));
          System.out.println("Stream to LinkedList: " + linkedList);

          // 2. Stream to Set
          Set<Integer> aSet = input.stream().collect(Collectors.toSet());
          System.out.println("Stream to Set: " + aSet);

          // Stream to HashSet
          HashSet<Integer> anHashSet = input.stream()
                    .collect(Collectors.toCollection(HashSet::new));
          System.out.println("Stream to HashSet: " + anHashSet);

          // Stream to LinkedHashSet
          LinkedHashSet<Integer> aLinkedHashSet = input.stream()
                    .collect(Collectors.toCollection(LinkedHashSet::new));
          System.out.println("Stream to LinkedHashSet: " + aLinkedHashSet);

          // 3. Stream to Map
          Map<Integer, String> aMap = input.stream()
                    .collect(Collectors.toMap(
                              Function.identity(), String::valueOf, (k1, k2) -> k1));
          System.out.println("Stream to Map: " + aMap);

          // Stream to HashMap
          HashMap<Integer, String> anHashMap = input.stream()
                    .collect(Collectors.toMap(
                              Function.identity(), String::valueOf, (k1, k2) -> k1, HashMap::new));
          System.out.println("Stream to HashMap: " + anHashMap);

          // Stream to LinkedHashMap
          LinkedHashMap<Integer, String> aLinkedHashMap = input.stream()
                    .collect(Collectors.toMap(
                              Function.identity(), String::valueOf, (k1, k2) -> k1, LinkedHashMap::new));
          System.out.println("Stream to LinkedHashMap: " + aLinkedHashMap);

          // 4. Stream to ConcurrentMap
          ConcurrentMap<Integer, String> aConcurrentMap = input.parallelStream()
                    .collect(Collectors.toConcurrentMap(
                              Function.identity(), String::valueOf, (k1, k2) -> k1));
          System.out.println("Stream to ConcurrentMap: " + aConcurrentMap);

          // Stream to ConcurrentHashMap
          ConcurrentHashMap<Integer, String> aConcurrentHashMap = input.parallelStream()
                    .collect(Collectors.toConcurrentMap(
                              Function.identity(), String::valueOf, (k1, k2) -> k1, ConcurrentHashMap::new));
          System.out.println("Stream to ConcurrentHashMap: " + aConcurrentHashMap);

     }

}
