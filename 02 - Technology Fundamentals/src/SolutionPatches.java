import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionPatches {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String S = reader.readLine();

        System.out.println(solution(S));

    }

    public static int solution(String S) {
        // write your code in Java SE 8
        char[] pathCharArray = S.toCharArray();

        int patches = 0;


        for (int i = 0; i < pathCharArray.length; i++) {

            if(String.valueOf(pathCharArray[i]).equals("X")){
                patches++;
                i +=2;
            }
        }


        return patches;
    }
}
