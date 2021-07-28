package A08_Generics.exercise.e04GenericSwapMethodInteger;



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
        List<Box<Integer>> boxes = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            int str = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(str);

            boxes.add(box);
        }

        String[] input = reader.readLine().split("\\s+");

        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);

        swapElements(boxes, firstIndex, secondIndex);

        for (Box<Integer> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}
