package A05_FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class E11ThePartyReservationFilterModule {

//    You are a young and talented developer. The first task you need to do is to implement a filtering module to a
//    party reservation software. First, The Party Reservation Filter Module (TPRF Module for short) is passed a list
//    with invitations. Next the TPRF receives a sequence of commands that specify if you need to add or remove a given
//    filter.
//    TPRF Commands are in the given format {command;filter type;filter parameter}
//    You can receive the following TPRF commands: "Add filter", "Remove filter" or "Print". The possible TPRF filter
//    types are: "Starts with", "Ends with", "Length" and "Contains". All TPRF filter parameters will be a string
//    (or an integer for the length filter).
//    The input will end with a "Print" command. See the examples below:

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String[] names = reader.readLine().split("\\s+");
        String command = reader.readLine();
        HashMap<String, Predicate<String>> predicates = new HashMap<>();

        while (!command.equals("Print")){
            String[] tokens = command.split(";");

            String type = tokens[1];
            String criteria = tokens[2];

            String filterName = type + criteria;

            if(tokens[0].contains("Add")){
                Predicate<String> predicate;

                if(type.contains("Starts")){
                    predicate = str -> str.startsWith(criteria);
                }else if(type.contains("Ends")){
                    predicate = str -> str.endsWith(criteria);
                }else if(type.contains("Length")){
                    predicate = str -> str.length() == Integer.parseInt(criteria);
                }else {
                    predicate = str -> str.contains(criteria);
                }

                predicates.putIfAbsent(filterName, predicate);

            }else {
                predicates.remove(filterName);
            }

            command = reader.readLine();
        }

        Arrays.stream(names).forEach(name -> {
            boolean[] hasToBeFiltered = new boolean[1];

            predicates.forEach((k,v) ->{
                if(v.test(name)){
                    hasToBeFiltered[0] = true;
                }
            });
            if(!hasToBeFiltered[0]){
                System.out.print(name + " ");
            }
        });
    }
}
