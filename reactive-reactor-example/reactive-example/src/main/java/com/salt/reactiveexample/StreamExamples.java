package com.salt.reactiveexample;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.salt.reactiveexample.domain.Person;
import com.salt.reactiveexample.domain.Product;


public class StreamExamples {
    
    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {  

        List<String> letters = List.of("a","b","c");
        try (Stream upper = letters.stream().map(String::toUpperCase)) {
            System.out.println(upper.toList());
        }

        Person p1 = new Person(1, "Pedro", LocalDate.of(1991, 1, 21));
        Person p2 = new Person(2, "Carlos", LocalDate.of(1990, 2, 21));
        Person p3 = new Person(3, "Jaime", LocalDate.of(1980, 6, 23));
        Person p4 = new Person(4, "Duke", LocalDate.of(2019, 5, 15));
        Person p5 = new Person(5, "James", LocalDate.of(2010, 1, 4));

        Product pr1 = new Product(1, "Ceviche", 15.0);
        Product pr2 = new Product(2, "Chilaquiles", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(4, "Ceviche", 15.0);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);

        // persons.forEach(System.out::println);
        // products.forEach(System.out::println);

        // Filter (param:  Predicate)
        List<Person> filteredList1 = persons.stream()
                .filter(p -> StreamExamples.getAge(p.getBirthDate()) >= 18)
                .collect(Collectors.toList());
        System.out.println("filtered list: ");
        StreamExamples.printList(filteredList1);


        Function<String, String> coderFunction = name -> "Name:" + name;
        //Map   
        List<String> filteredList2 = persons.stream()
                //.filter(p -> StreamExamples.getAge(p.getBirthDate()) >= 18)
                //.map(p -> StreamExamples.getAge(p.getBirthDate()))
                //.map(p -> p.getName())
                .map(Person::getName)
                .map(coderFunction)
                .collect(Collectors.toList());

        System.out.println("filtered list: ");
        StreamExamples.printList(filteredList2);
        
        Comparator<Person> byNameAsc = (Person o1, Person o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Person> byNameDesc = (Person o1, Person o2) -> o2.getName().compareTo(o1.getName());
        Comparator<Person> byBirthDate = (Person o1, Person o2) -> o1.getBirthDate().compareTo(o2.getBirthDate());

        //Sorted
        List<Person> filteredList3 = persons.stream()
                                            .sorted(byNameAsc)
                                            .collect(Collectors.toList());


        System.out.println("filtered list: ");
        StreamExamples.printList(filteredList3);
                                    

        // anyMatch : Does not evaluate the whole list and terminates with the first occurrence
        Predicate<Person> startsWithPredicate = person -> person.getName().startsWith("J");

        boolean rpta1 = persons.stream()
                                .anyMatch(startsWithPredicate); 

                                System.out.println("rpta1: " + rpta1);


        // allMatch : evaluate the whole stream
        boolean rpta2 = persons.stream()
                                .allMatch(person -> person.getName().startsWith("J"));        

                                System.out.println("rpta2: " + rpta2);

        // noneMatch : 
        boolean rpta3 = persons.stream()
                                .noneMatch(person -> person.getName().startsWith("X"));      

                                System.out.println("rpta3: " + rpta3);


        // Limit /skip
        int pageNumber = 1;
        int pageSize = 2;

        List<Person> filteredList4 = persons.stream()
                                        .skip(pageNumber* pageSize)
                                        .limit(pageSize)
                                        .collect(Collectors.toList());

        System.out.println("paged and skip list: ");
        StreamExamples.printList(filteredList4);
                    

        // 6-Collectors
        // GroupBy
        Map<String, List<Product>> collect1 = products.stream()
                                                .filter(p -> p.getPrice() < 20)
                                                .collect(Collectors.groupingBy(Product::getName));
        System.out.println(collect1);

        // Counting
        Map<String, Long> collect2 = products.stream()
                                            .collect(Collectors.groupingBy(
                                                Product::getName, Collectors.counting()
                                                )
                                            );
        System.out.println(collect2);
        
        //Agrupando por nombre producto y sumando
        Map<String, Double> collect3 = products.stream()
                                            .collect(Collectors.groupingBy(
                                                Product::getName, 
                                                Collectors.summingDouble(Product::getPrice)
                                                )
                                            );
        System.out.println(collect3);
        
        //Obteniendo suma y resumen
        DoubleSummaryStatistics statistics = products.stream()
                                                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println(statistics);
        
        //7-reduce        
        Optional<Double> sum = products.stream()
                                    .map(Product::getPrice)
                                    .reduce(Double::sum);
                                    //.reduce((a,b) -> a+b)
        System.out.println(sum.get());

    }

}
