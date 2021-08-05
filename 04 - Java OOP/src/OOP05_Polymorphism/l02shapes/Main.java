package OOP05_Polymorphism.l02shapes;

public class Main {

    public static void main(String[] args) {
        Shape shape = new Rectangle(5.0, 5.0);
        shape.calculateArea();

        System.out.println(shape.getArea());
    }
}
