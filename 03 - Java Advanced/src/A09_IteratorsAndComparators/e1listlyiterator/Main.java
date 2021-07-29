package A09_IteratorsAndComparators.e1listlyiterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());


        ListlyIterator iterator = new ListlyIterator(list);

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String output = "";
            switch (line) {
                case "Move":
                    output = iterator.move() ? "true" : "false";
                    break;
                case "Print":
                    try {
                        output = iterator.print();
                    } catch (IllegalAccessException e) {
                        output = e.getMessage();
                    }
                    break;
                case "HasNext":
                    output = iterator.hasNext() ? "true" : "false";
                    break;
            }

            line = scanner.nextLine();
            System.out.println(output);
        }

    }
}
