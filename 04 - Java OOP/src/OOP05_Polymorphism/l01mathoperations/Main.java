package OOP05_Polymorphism.l01mathoperations;

public class Main {

    public static void main(String[] args) {
        MathOperations mathOperations = new MathOperations();

        System.out.println(mathOperations.add(2, 2));
        System.out.println(mathOperations.add(3, 3, 3));
        System.out.println(mathOperations.add(4, 4, 4, 4));
    }
}
