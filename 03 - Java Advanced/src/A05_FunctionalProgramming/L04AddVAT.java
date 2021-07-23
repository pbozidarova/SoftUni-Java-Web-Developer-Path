package A05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class L04AddVAT {

//    Write a program that reads one line of Double prices separated by ", ". Print the prices with added VATs for all
//    of them. Format them to the 2nd digit after the decimal point. The order of the prices must remain the same.
//    Use an UnaryOperator<Double>

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String[] prices = reader.readLine().split(", ");

        UnaryOperator<Double> addVat = d -> d * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(d -> System.out.printf("%.2f%n", d));
    }
}
