package OOP08_ExceptionsAndErrorHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L01SquareRoot {

    public static void main(String[] args) {

        try(
            BufferedReader reader = new BufferedReader (
                    new InputStreamReader(
                            System.in
                    )
            );
        ) {
            int num = Integer.parseInt(reader.readLine());

        }catch (NumberFormatException e){
            System.out.println("Invalid number");
        } catch (IOException ignored) {

        }finally {
            System.out.println("Good bye");
        }
    }
}
