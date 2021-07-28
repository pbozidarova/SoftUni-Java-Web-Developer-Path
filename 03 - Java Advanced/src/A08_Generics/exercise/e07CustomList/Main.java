package A08_Generics.exercise.e07CustomList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

//        Add <element> - Adds t
//        Remove <index> - Remo
//        Contains <element> - Pr
//        Swap <index> <index> -
//        Greater <element> - Co
//        Max - Prints the maximu
//        Min - Prints the minimu
//        Print - Prints all element
//        END - stops the reading

        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.forEach(System.out::println);
                    break;
                default:
                    break;

            }


            input = scanner.nextLine();
        }

    }
}
