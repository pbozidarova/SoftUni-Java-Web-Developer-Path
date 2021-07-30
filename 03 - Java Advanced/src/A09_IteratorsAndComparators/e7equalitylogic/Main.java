package A09_IteratorsAndComparators.e7equalitylogic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> peopleTree = new TreeSet<>();
        HashSet<Person> peopleHash = new HashSet<>();
        
        int n = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0){
            String input = scanner.nextLine();

            String[] tokens = input.split("\\s+");

            Person p = new Person(tokens[0],
                    Integer.parseInt(tokens[1]));

            peopleTree.add(p);
            peopleHash.add(p);
        }

        System.out.println(peopleTree.size());
        System.out.println(peopleHash.size());
    }
}
