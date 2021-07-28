package A08_Generics.exercise.e10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );
        String firstLine = reader.readLine();
        String name = firstLine.substring(0, firstLine.lastIndexOf(" "));
        String address = firstLine.substring(firstLine.lastIndexOf(" ") +1);

        String secondLine = reader.readLine();
        String person = secondLine.substring(0, secondLine.indexOf(" "));
        int liters = Integer.parseInt(secondLine.substring(secondLine.indexOf(" ") + 1));

        String[] forth = reader.readLine().split("\\s+");
        int number = Integer.parseInt(forth[0]);
        double floatingPoint = Double.parseDouble(forth[1]);

        Tuple<String, String> first = new Tuple<>(name, address);
        Tuple<String, Integer> second = new Tuple<>(person, liters);
        Tuple<Integer, Double> third = new Tuple<>(number, floatingPoint);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());

    }
}
