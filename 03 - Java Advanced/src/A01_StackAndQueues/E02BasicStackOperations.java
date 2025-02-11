package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E02BasicStackOperations {

//    You will be given an integer N representing the number of elements to push onto the stack,
//    an integer S representing the number of elements to pop from the stack and finally an integer X,
//    an element that you should check whether is present in the stack. If it is, print true on the console.
//    If it’s not, print the smallest element currently present in the stack.
//
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] parameters = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsCount = parameters[0];
        int countToRemove = parameters[1];
        int lookupElement = parameters[2];

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsCount)
                .forEach(numbersStack::push);

        while (countToRemove-- > 0){
            numbersStack.pop();
        }
        if(numbersStack.contains(lookupElement)){
            System.out.println("true");
        }else {
            if(numbersStack.size() == 0){
                System.out.println(0);
            }else {
//                System.out.println(Collections.min(numbersStack));
                int min = Integer.MAX_VALUE;

                while (!numbersStack.isEmpty()){
                    int number = numbersStack.pop();
                    if(number < min){
                        min = number;
                    }
                }

                System.out.println(min);
            }
        }


    }
}
