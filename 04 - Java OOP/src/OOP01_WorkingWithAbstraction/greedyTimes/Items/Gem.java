package OOP01_WorkingWithAbstraction.greedyTimes.Items;

public class Gem extends Item {
    private String name;

    public Gem(String name, long quantity) {
        super(quantity);
        this.name = name;

    }
}
