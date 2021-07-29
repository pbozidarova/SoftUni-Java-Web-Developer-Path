package A08_Generics.e05GenericCountMethodStrings;

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

        List<Box<String>> boxes = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String str = reader.readLine();
            Box<String> box = new Box<>(str);

            boxes.add(box);
        }
        
        Box<String> element = new Box<>(reader.readLine());
        
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
