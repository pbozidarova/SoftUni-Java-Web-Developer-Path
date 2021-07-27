package A07_Workshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void push(int element){
        this.add(element);
    }


    public int pop(){
        return this.remove(this.size - 1);
    }

    public int peek(){
        return this.get(this.size - 1);
    }

    public boolean contains(int element){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element) return true;
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private void add(int element) {
        if(this.size == this.capacity){
            this.resize();
        }

        this.data[this.size++] = element;
    }



    private int get(int index){
        checkIndex(index);

        return this.data[index];
    }


    private int remove(int index){
        checkIndex(index);

        int element = this.data[index];

        this.shiftLeft(index);
        this.size--;

        if(this.size <= this.capacity / 4){
            this.shrink();
        }

        return element;
    }


    private void shrink(){
        this.capacity /= 2;

        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

//        if (this.size >= 0) {
//            System.arraycopy(this.data, 0, newData, 0, this.size);
//        }

        this.data = newData;
    }


    private void shiftLeft(int index) {
        for (int i = index; i < this.size -1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size -1] = 0;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= this.size){
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new NoSuchElementException(message);
        }
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
}

