package OOP05_Polymorphism.l03animal;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Matsa", "Fish");
        Animal dog = new Dog("Sharo", "Potato");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
