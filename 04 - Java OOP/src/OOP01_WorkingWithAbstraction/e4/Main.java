package OOP01_WorkingWithAbstraction.e4;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        int n = Integer.parseInt(sc.nextLine());

        TrafficLight[] lights = new TrafficLight[input.length];

        for (int i = 0; i < input.length ; i++) {
            lights[i] = TrafficLight.valueOf(input[i]);
        }

        TrafficLight[] lightsValues = {TrafficLight.RED, TrafficLight.GREEN, TrafficLight.YELLOW};
        while (n-- > 0){
            for (int i = 0; i < lights.length; i++) {
                if(lights[i].ordinal() == 2){
                    lights[i] = TrafficLight.RED;
                }else{
                    lights[i] = lightsValues[lights[i].ordinal() +1];
                }
                System.out.print( lights[i].toString() + " ");
                
            }
            System.out.println();
        }

    }
}
