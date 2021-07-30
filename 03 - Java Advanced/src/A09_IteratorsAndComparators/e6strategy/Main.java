package A09_IteratorsAndComparators.e6strategy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> peopleTreeAge = new TreeSet<>(new PersonByAge());
        TreeSet<Person> peopleTreeName = new TreeSet<>(new PersonByName());


        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            Person p = new Person(tokens[0],
                    Integer.parseInt(tokens[1]));

            peopleTreeAge.add(p);
            peopleTreeName.add(p);
        }

        for (Person person : peopleTreeName) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        for (Person person : peopleTreeAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}
