package OOP05_Polymorphism.l01mathoperations;

public class MathOperations {

    public int add(int a, int b){
        return this.sumTwoNumbers(a, b);
    }

    public int add(int a, int b, int c){
        return this.sumTwoNumbers(this.sumTwoNumbers(a,b), c);
    }

    public int add(int a, int b, int c, int d){
        return this.sumTwoNumbers(this.add(a, b, c), d);
    }

    private int sumTwoNumbers(int a, int b){
        return a + b;
    }
}
