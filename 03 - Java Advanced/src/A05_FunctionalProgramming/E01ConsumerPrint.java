package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01ConsumerPrint {

//    Write a program that reads a collection of strings, separated by one or more whitespaces, from the console and
//    then prints them onto the console. Each string should be printed on a new line. Use a Consumer<T>.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printer = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);


    }
}
