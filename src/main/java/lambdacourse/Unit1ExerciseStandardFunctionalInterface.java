package lambdacourse;

import java.util.*;
import java.util.function.*;

public class Unit1ExerciseStandardFunctionalInterface {

    public static void main(String[] args){

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );


        // Step 1 sort a list by last name
        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        // Step 2 create a method that prints all elements in the list
        printAllElementsConditionally(people, p -> true, p -> System.out.println(p));

        // Step 3 Create a method that prints all people that have last name beginning with C
        printAllElementsConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        // Step 4 Create a method that prints Just first name starts with C
        printAllElementsConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getFirstName()));

        // Step 5 Create a method that prints all with for each
        printAllElementsConditionallyForEach(people, p -> true, p -> System.out.println(p));

        // Step 6 Print all persons with age bigger than 30
        printLastNameAgeBigger30(people, p -> p.getAge() > 50, (lastName, age) -> System.out.println(lastName + "," + age));

        // Step 7 Create a method that prints biPredicate
        printAllElementsBiPredicate(people, (p, string) -> p.getLastName().startsWith(string), p -> System.out.println(p.getFirstName()));

        // Step 8 Function to take an integer and convert to string
        Function<Integer, String> intToString = integer -> integer.toString();
        System.out.println(intToString.apply(10));

        // Step 9 add in the map if doenst exist
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        Integer value2 = nameMap.computeIfAbsent("John", String::length);


    }

    public static void printAllElementsConditionally(List<Person> people, Predicate<Person> predicate,
                                                     Consumer<Person> consumer){
        for(Person p : people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    public static void printAllElementsBiPredicate(List<Person> people, BiPredicate<Person, String> predicate,
                                                     Consumer<Person> consumer){
        for(Person p : people){
            if(predicate.test(p, "C")){
                consumer.accept(p);
            }
        }
    }

    public static void printAllElementsConditionallyForEach(List<Person> people, Predicate<Person> predicate,
                                                            Consumer<Person> consumer){
        people.stream().filter(predicate).forEach(consumer);
    }

    public static void printLastNameAgeBigger30(List<Person> people, Predicate<Person> predicate,
                                                BiConsumer<String, Integer> biConsumer){
        for(Person p : people) {
            if(predicate.test(p)) {
                biConsumer.accept(p.getLastName(), p.getAge());
            }
        }
    }
}
