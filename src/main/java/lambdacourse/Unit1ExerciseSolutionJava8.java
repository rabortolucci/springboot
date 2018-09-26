package lambdacourse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1ExerciseSolutionJava8 {

    public static void main(String[] args){

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Step 1 sort a list by last name
        // Step 2 create a method that prints all elements in the list
        // Step 3 Create a method that prints all people that have last name beginning with C


        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        printAllElementsConditionally(people, p -> true);
        printAllElementsConditionally(people, p -> p.getLastName().startsWith("C"));
    }

    public static void printAllElementsConditionally(List<Person> people, Conditionally c){
        for(Person p : people){
            if(c.test(p)){
                System.out.println(p.toString());
            }
        }
    }
}
