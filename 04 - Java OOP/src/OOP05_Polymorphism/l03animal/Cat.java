package OOP05_Polymorphism.l03animal;

public class Cat extends Animal{
    private final static String MEEOW = "MEEOW";

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {

        return String.format("%s %n%s",
                super.baseExplain(),
                MEEOW);
    }
}
