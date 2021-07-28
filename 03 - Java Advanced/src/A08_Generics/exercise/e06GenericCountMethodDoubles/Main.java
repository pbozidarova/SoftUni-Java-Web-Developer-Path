package A08_Generics.exercise.e06GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        List<Box<Double>> boxes = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            Double str = Double.valueOf(reader.readLine());
            Box<Double> box = new Box<>(str);

            boxes.add(box);
        }
        
        Box<Double> element = new Box<>(Double.parseDouble(reader.readLine()));
        
        int count = countGreaterElements(boxes, element);

        System.out.println(count);
    }

    private static <T extends Comparable<T>> int countGreaterElements(List<Box<T>> boxes, Box<T> element) {
        int count = 0;

        for (Box<T> box : boxes) {
            if(box.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

}
