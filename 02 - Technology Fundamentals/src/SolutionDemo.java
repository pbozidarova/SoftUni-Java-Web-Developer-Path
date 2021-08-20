import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SolutionDemo {


//    Write a function:
//
//    class Solution { public int solution(int[] A); }
//
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//    Given A = [1, 2, 3], the function should return 4.
//
//    Given A = [−1, −3], the function should return 1.
//
//    Write an efficient algorithm for the following assumptions:
//
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].
//


    public void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );

        String input = reader.readLine();
        String givenA = input.substring(1, input.length() - 1);

        int[] A = Arrays.stream(givenA.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        HashSet<Integer> intoSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            intoSet.add(A[i]);
        }

        int number = 1;

        boolean isNotInTheSet = false;

        while (!isNotInTheSet) {
            if (intoSet.contains(number)) {
                number++;
            } else {
                isNotInTheSet = true;
            }
        }

        return number;
    }
}
