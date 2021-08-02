package OOP05_Polymorphism.e3_.farm.animals;

public class Mouse extends Mammal {

    public Mouse(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }
}
