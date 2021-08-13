import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String message = "Hello world!";

        String newM = message.substring(6, 12) + message.substring(12, 6);

        System.out.println(newM);
    }
}
