package A07_Workshop;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if(this.size == this.capacity){
            this.resize();
        }

        this.data[this.size++] = element;
    }


    private void resize(){
        this.capacity *= 2;
        int[] copy = new int[this.capacity];

//        for (int i = 0; i < this.data.length; i++) {
//            copy[i] = this.data[i];
//        }


        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }

    public int get(int index){
        checkIndex(index);

        return this.data[index];
    }

    private void checkIndex(int index){
        if(index < 0 || index >= this.size){
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int remove(int index){
        checkIndex(index);

        return 0;
    }

}
