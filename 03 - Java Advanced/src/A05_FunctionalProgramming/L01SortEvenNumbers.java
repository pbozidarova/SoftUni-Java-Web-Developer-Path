package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L01SortEvenNumbers {

//    Write a program that reads one line of Integers separated by ", ".
//•	Print the even numbers
//•	Sort them in ascending order
//•	Print them again.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

        evenNumbers.sort(Integer::compareTo);
//        evenNumbers.sort((x, y) -> (x < y) ? -1 : ((x==y) ? 0 : 1));
        List<String> evenSorted = evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenSorted));
    }
}
