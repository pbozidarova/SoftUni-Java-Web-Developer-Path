package OOP01_WorkingWithAbstraction.greedyTimes.Items;

public abstract class Item {
    private long quantity;

    protected Item(long quantity){
        this.quantity = quantity;
    }
}
