package OOP05_Polymorphism.l03animal;

public class Dog extends Animal{
    private final static String DJAAF = "DJAAF";

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {

        return String.format("%s %n%s",
                super.baseExplain(),
                DJAAF);

    }
}
