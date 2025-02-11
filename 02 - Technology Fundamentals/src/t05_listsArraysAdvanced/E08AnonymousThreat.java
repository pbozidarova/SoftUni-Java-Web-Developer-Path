package t05_listsArraysAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E08AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        List<String> elements = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";

        while(!"3:1".equals(input = reader.readLine())){
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command){
                case "merge":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);

                    startIndex = validateIndex(startIndex, elements.size());
                    endIndex = validateIndex(endIndex, elements.size());


                    String concatElemets = String.join("", elements.subList(startIndex, endIndex+1));
                    //if (concatElemets.length() > 0) {
                    elements.subList(startIndex, endIndex+1).clear();
                    elements.add(startIndex, concatElemets);
                    //}

                    break;
                case "divide":
                    int index = Integer.parseInt(data[1]);
                    int partitions = Integer.parseInt(data[2]);

                    List<String> result = devidedEqually(elements.get(index), partitions);
                    elements.remove(index);
                    elements.addAll(index, result);
                    break;

            }
        }

        System.out.println(elements.toString().replaceAll("[\\[,\\]]",""));
    }

    private static List<String> devidedEqually(String element, int partitions) {
        int part = element.length()/partitions;
        ArrayList<String> result = new ArrayList<>();

        while(element.length() >= part){
            result.add(element.substring(0, part));
            element = element.substring(part);
        }

        if(result.size() == partitions){
            return result;
        } else{
            String concatLastTwoElements = result.get(result.size()-2).concat(
                    result.get(result.size()-1));
            result.subList(result.size()-2, result.size()-1).clear();
            result.add(concatLastTwoElements);
            return result;
        }
    }

    private static int validateIndex(int index, int length){
        if (index < 0) index = 0;

        if (index > length -1 ) index = length -1;

        return index;
    }
}
