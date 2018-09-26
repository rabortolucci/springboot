package lambdacourse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

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

        sortByLastName(people);

        printAllElements(people, new PrintAllInterface() {
            @Override
            public void printAll(Person p) {
                System.out.println(p.toString());
            }
        });

        printAllElementsLastNameBeginningCConditionally(people, new Conditionally() {
            @Override
            public boolean test(Person p) {
                if(p.getLastName().startsWith("C"))
                    return true;
                return false;
            }
        });
    }

    public static void sortByLastName(List<Person> people){
        Collections.sort(people, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }


    public static void printAllElements(List<Person> people, PrintAllInterface printAllInterface){
        for(Person p : people){
            printAllInterface.printAll(p);
        }
    }


    public static void printAllElementsLastNameBeginningCConditionally(List<Person> people, Conditionally c){
        for(Person p : people){
            if(c.test(p)){
                System.out.println(p.toString());
            }
        }
    }
}

interface Conditionally{
    boolean test(Person p);
}

interface PrintAllInterface{
    void printAll(Person p);
}
