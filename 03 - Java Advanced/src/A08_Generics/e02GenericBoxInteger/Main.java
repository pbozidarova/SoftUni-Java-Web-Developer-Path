package A08_Generics.e02GenericBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            int str = Integer.parseInt(reader.readLine());

            Box<Integer> box = new Box<>(str);

            System.out.println(box.toString());
        }
    }
}
