package A07_Workshop;

import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedList<T>{

//    In this workshop, we are going to create another custom data structure, which has similar functionalities as the Java LinkedList. Just like the structures from the previous workshop, our custom LinkedList will work only with integers. It will have the following functionalities:
//•	void addFirst(int element) – adds an element at the beginning of the collection
//•	void addLast(int element) – adds an element at the end of the collection
//•	int get(int index) - Returns the element at the specified position in this list
//•	int removeFirst() – removes the element at the beginning of the collection
//•	int removeLast() – removes the element at the end of the collection
//•	void forEach() – goes through the collection and executes a given action
//•	int[] toArray() – returns the collection as an array

    private class Node{
        Node next;
        Node prev;
        T element;

        public Node(T element){
            this.next = null;
            this.prev = null;
            this.element = element;

        }
    }

    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T element){
        if(this.head == null){
            this.addLast(element);
        }else {
            Node newNode = new Node(element);
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            this.size++;
        }

    }

    public void addLast(T element){
        Node newNode = new Node(element);

        if(this.head == null){
            this.head = this.tail = newNode;

        }else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public T removeFirst(){

        this.checkSize();
        T value = this.head.element;

        this.head = this.head.next;
        this.head.prev = null;
        this.size--;

        return value;
    }

    public T removeLast(){
        this.checkSize();

        T value = this.tail.element;

        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;

        return value;
    }

    public T[] toArray(){
        this.checkSize();
        T[] result = (T[]) new Object[this.size];

        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null){
            result[index++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return result;
    }

    public void forEach(Consumer<T> consumer){
        Node currentNode = this.head;

        while (currentNode != null){
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    private void checkSize(){
        if(this.size == 0){
            throw new IndexOutOfBoundsException("Invalid remove from empty collection");
        }
    }


    public T get(int index){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Invalid index for value of " + index + ". Collection size " + this.size);
        }

        int counter = 0;

        T value = null;

        Node currentNode = this.head;

        while (currentNode != null){
            if(counter == index){
                value = currentNode.element;
                break;
            }
            currentNode = currentNode.next;
            counter++;
        }

        return value;
    }

}
