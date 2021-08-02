package OOP05_Polymorphism.e3_.farm.foods;

public abstract class Food {
    private int quantity;

    protected Food(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
