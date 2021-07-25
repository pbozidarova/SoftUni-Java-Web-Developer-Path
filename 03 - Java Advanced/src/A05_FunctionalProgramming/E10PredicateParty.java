package A05_FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E10PredicateParty {

//    The Wire’s parents are on a vacation for the holidays and he is planning an epic party at home. Unfortunately,
//    his organizational skills are next to non-existent so you are given the task to help him with the reservations.
//    On the first line you get a list with all the people that are coming. On the next lines, until you get the
//    "Party!" command, you may be asked to double or remove all the people that apply to given criteria.
//    There are three different options:
//•	Everyone that has a name starting with a given string;
//•	Everyone that has a name ending with a given string;
//•	Everyone that has a name with a given length.
//    When you print the guests that are coming to the party, you have to print them in ascending order.
//    If nobody is going, print "Nobody is going to the party!". See the examples below:


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();

        while (!command.equals("Party!")){
            String[] tokens = command.split("\\s+");
            Predicate<String> predicate =  createPredicate(tokens[1], tokens[2]);

            if(tokens[0].equals("Remove")){
                names.removeIf(predicate);
            }else {

                ArrayList<String> namesToAdd = new ArrayList<>();

                names.forEach(name -> {
                    if(predicate.test(name)){
                        namesToAdd.add(name);
                    }
                });

                names.addAll(namesToAdd);
            }

            command = scanner.nextLine();
        }

        Collections.sort(names);
        System.out.println(names.size() == 0
                ? "Nobody is going to the party!"
                : String.join(", ", names) + " are going to the party!");
//        names.stream().sorted().forEach(System.out::println);
    }

    public static Predicate<String> createPredicate(String type, String string){
        Predicate<String> predicate;

        switch (type){
            case "StartsWith":
                predicate = str -> str.startsWith(string);
                break;
            case "EndsWith":
                predicate = str -> str.endsWith(string);
                break;
            default:
                predicate = str -> str.length() == Integer.parseInt(string);
                break;
        }

        return predicate;
    }
}
