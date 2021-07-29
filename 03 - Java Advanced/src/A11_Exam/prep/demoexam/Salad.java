package A11_Exam.prep.demoexam;

import java.util.*;
import java.util.stream.Collectors;

public class Salad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vegetables = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> calories = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(calories::push);

        Map<String, Integer> table = new HashMap<>();

        table.put("tomato", 80);
        table.put("carrot", 136);
        table.put("lettuce", 109);
        table.put("potato", 215);

        List<Integer> salads = new ArrayList<>();

        while (!vegetables.isEmpty() && !calories.isEmpty()){
            int salad = calories.peek();

            while (salad > 0){
                String vegetable = vegetables.poll();
                if(vegetable == null){
                    break;
                }
                int caloriesToRemove = 0;
                if (table.containsKey(vegetable)) {

                    caloriesToRemove = table.get(vegetable);
                }
                salad -= caloriesToRemove;
            }

            salads.add(calories.pop());
        }

        for (Integer salad : salads) {
            System.out.print(salad + " ");
        }
        System.out.println();

        if(!calories.isEmpty()){
            for (Integer calorie : calories) {
                System.out.print(calorie + " ");
            }
        }else {
            for (String vegetable : vegetables) {
                System.out.println(vegetable + " ");
            }
        }
    }
}
