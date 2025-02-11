package A05_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class E09ListOfPredicates {

//    Find all numbers in the range 1..N that are divisible by the numbers of a given sequence. Use predicates.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ToIntFunction<String> mapper = Integer::parseInt;

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(mapper)
                .toArray();

        Predicate<Integer> shouldPrint = num -> {
            boolean isPrintable = true;

            for (int element : sequence) {
                if(num % element != 0){
                    isPrintable = false;
                    break;
                }
            }

            return isPrintable;
        };

        for (int i = 1; i <= n ; i++) {
            if(shouldPrint.test(i)){
                System.out.print(i + " ");
            }
        }

    }
}
