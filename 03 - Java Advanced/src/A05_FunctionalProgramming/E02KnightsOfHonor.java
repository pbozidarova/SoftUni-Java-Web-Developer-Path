package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02KnightsOfHonor {
//    Write a program that reads a collection of names as strings from the console and then appends “Sir” in front of
//    every name and prints it back onto the console. Use a Consumer<T>.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printer = x -> System.out.println("Sir " + x);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);

    }
}
