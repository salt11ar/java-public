package edu.examples;

// Java Program to Illustrate How We can Use
// constructor method reference
 
// Importing required classes
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
 
// Object need to be sorted
class Person {
    private String name;
    private Integer age;
 
    // Constructor
    public Person()
    {
        Random ran = new Random();
 
        // Assigning a random value
        // to name
        this.name
            = ran
                  .ints(97, 122 + 1)
                  .limit(10)
                  .collect(StringBuilder::new,
                           StringBuilder::appendCodePoint,
                           StringBuilder::append)
                  .toString();
    }
 
    public Integer getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
}
 
public class ConstructorMethodReference {
 
    // Get List of objects of given
    // length and Supplier
    public static <T> List<T>
    getObjectList(int length,
                  Supplier<T> objectSupply)
    {
        List<T> list = new ArrayList<>();
 
        for (int i = 0; i < length; i++)
            list.add(objectSupply.get());
        return list;
    }
 
    public static void main(String[] args)
    {
 
        // Get 10 person by supplying
        // person supplier, Supplier is
        // created by person constructor
        // reference
        List<Person> personList
            = getObjectList(5, Person::new);
 
        // Print names of personList
        personList.stream()
            .map(x -> x.getName())
            .forEach(System.out::println);
    }
}