package OOP01_WorkingWithAbstraction.e3;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int value;
    CardSuit(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
