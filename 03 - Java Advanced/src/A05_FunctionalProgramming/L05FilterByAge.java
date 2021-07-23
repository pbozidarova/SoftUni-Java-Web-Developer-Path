package A05_FunctionalProgramming;

import java.text.Format;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L05FilterByAge {

//    Write a program that reads an integer N on the first line. And on next N lines read pairs of "[name], [age]".
//    Then read three more lines with:
//            •	Condition - "younger" or "older"
//            •	Age - Integer
//            •	Format - "name", "age" or "name age"
//    Depending on the condition, print the pairs in the right format.
//    Don’t use any build-in functionality. Write your own methods.

    public static void main(String[] args) {
        BiPredicate<Map.Entry<String, Integer>, Integer> youngerThan =
                (person, ageLimit) -> person.getValue() < ageLimit;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (person, ageLimit) -> person.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName = p -> System.out.println(p.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = p -> System.out.println(p.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = p -> System.out.printf("%s - %d%n", p.getKey(), p.getValue());

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] personData = scanner.nextLine().split(", ");

            people.put(personData[0], Integer.parseInt(personData[1]));
        }

        String comparison = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        Consumer<Map.Entry<String, Integer>> print  = printNameAndAge;
        if(printType.equals("age")){
            print = printAge;
        }else if(printType.equals("name")){
            print = printName;
        }

        BiPredicate<Map.Entry<String, Integer>, Integer> byAge = youngerThan;
        if(comparison.equals("older")){
            byAge = olderThan;
        }

        BiPredicate<Map.Entry<String, Integer>, Integer> finalByAge = byAge;

//        people.entrySet().stream()
//                .filter(person -> comparison.equals("younger")
//                        ? youngerThan.test(person, ageLimit)
//                        : olderThan.test(person, ageLimit)
//                )
//                .forEach(person -> {
//                    if(printType.equals("age")){
//                        printAge.accept(person);
//                    }else if(printType.equals("name")){
//                        printName.accept(person);
//                    }else {
//                        printNameAndAge.accept(person);
//                    }
//                });

        people.entrySet().stream()
                .filter(person -> finalByAge.test(person, ageLimit))
                .forEach(print);


    }
}
