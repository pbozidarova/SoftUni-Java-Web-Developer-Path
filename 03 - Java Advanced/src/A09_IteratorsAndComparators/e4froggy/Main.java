package A09_IteratorsAndComparators.e4froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int[] nums;

        try {
            nums = Arrays.stream(bfr.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Lake lake = new Lake(nums);
        StringBuilder print = new StringBuilder();

        for (Integer integer : lake) {
            print.append(integer).append(", ");
        }

        lake.forEach(e -> print.append(e).append(", "));
        print.delete(print.length() - 2, print.length());
        System.out.println(print.toString());
    }
}