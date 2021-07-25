package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class E03CustomMinFunction {

//    Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers using a
//    simple Function<Integer[], Integer> .

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> minNumber = arr -> Arrays.stream(arr).min().getAsInt();

        System.out.println(minNumber.apply(numbers));

    }
}
