package A05_FunctionalProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L06FindEvensOrOdds {

//    You are given a lower and an upper bound for a range of integer numbers. Then a command specifies if you need to
//    list all even or odd numbers in the given range. Use predicates that need to be passed to a method.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String type = scanner.nextLine();

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        Predicate<Integer> filterEven = x -> x % 2 == 0;
        Predicate<Integer> filterOdd = x -> x % 2 != 0;

        Predicate<Integer> byType = filterEven;

        if(type.equals("odd")){
            byType = filterOdd;
        }

        IntStream.rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(byType)
                .forEach(x -> System.out.print(x + " "));
    }
}
