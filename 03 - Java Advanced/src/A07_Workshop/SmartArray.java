package A07_Workshop;

//The SmartArray will have similar functionality to Java ArrayList that you've used before. Our SmartArray will work only with integers for now, but after the Generics lecture from this course, you can try to change that and make the structure generic, which means it will be able to work with any type. It will have the following functionality:
//        •	void add(int element) - Adds the given element to the end of the list
//        •	int get(int index) - Returns the element at the specified position in this list
//        •	int remove(int index) - Removes the element at the given index
//        •	bool contains(int element) - Checks if the list contains the given element returns (True or False)
//        •	void add(int firstIndex, int secondIndex) - Adds element at the specific index, the element at this index gets shift to the right alongside with any following elements, increasing size
//        •	void forEach(Consumer<Integer> consumer) - Goes through each one of the elements in the list

//The custom stack will also have similar functionality to the Java ArrayDeque and again, we will make it work only with integers. Later on, we will learn how to implement it in a way that will allow us to work with any types. It will have the following functionality:
//        •	void push(int element) – Adds the given element to the stack
//        •	int pop() – Removes the last added element
//        •	int peek() – Returns the last element in the stack without removing it
//        •	void forEach(Consumer<Integer> consumer) – Goes through each of the elements in the stack


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class SmartArray<E> {

    private static final int INITIAL_CAPACITY = 4;

    private Object[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new Object[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(E element) {
        if(this.size == this.capacity){
            this.resize();
        }

        this.data[this.size++] = element;
    }


    public E get(int index){
        checkIndex(index);

        return (E) this.data[index];
    }


    public E remove(int index){
        checkIndex(index);

        Object element = this.data[index];

        this.shiftLeft(index);
        this.size--;

        if(this.size <= this.capacity / 4){
            this.shrink();
        }

        return (E) element;
    }

    public boolean contains(E element){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i] == element) return true;
        }
        return false;
    }

    public void forEach(Consumer<E> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept((E) this.data[i]);
        }
    }

    public void add(int index, int element){
        this.checkIndex(index);

        if(this.size + 1 >= this.capacity){
            this.resize();
        }
        this.size++;

        this.shiftRight(index);
        this.data[index] = element;
    }

    public void sort(Comparator<E> comparator){
        Arrays.sort((E[]) this.data, 0, this.size, comparator);
    }

    private void shrink(){
        this.capacity /= 2;

        Object[] newData = new Object[this.capacity];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }

//        if (this.size >= 0) {
//            System.arraycopy(this.data, 0, newData, 0, this.size);
//        }

        this.data = newData;
    }

    private void shiftRight(int index){
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i - 1];
        }
//        this.data[this.size -1] = 0;
    }


    private void shiftLeft(int index) {
        for (int i = index; i < this.size -1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[this.size -1] = null;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= this.size){
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void resize(){
        this.capacity *= 2;
        Object[] copy = new Object[this.capacity];

//        for (int i = 0; i < this.data.length; i++) {
//            copy[i] = this.data[i];
//        }


        System.arraycopy(this.data, 0, copy, 0, this.size);
        this.data = copy;
    }
}
