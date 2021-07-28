package A08_Generics.exercise.e09CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element){
        this.data.add(element);
    }

    public T remove(int index){
        return this.data.remove(index);
    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public T get(int index){
        return this.data.get(index);
    }

    public void swap(int firstIndex, int secondIndex){
        Collections.swap(this.data, firstIndex, secondIndex);
    }

    public int size(){
        return this.data.size();

    }

    public int countGreaterThan(T element){
        return (int) this.data.stream()
                .filter(value -> value.compareTo(element) > 0)
                .count();
    }

    public T getMax(){
        return Collections.max(this.data);
    }

    public T getMin(){
        return Collections.min(this.data);
    }

    public static <T extends Comparable<T>> void printList(CustomList customList) {
        customList.data.forEach(System.out::println);
    }

//    public void forEach(Consumer<T> consumer){
//        for (T element : this.data) {
//            consumer.accept(element);
//        }
//    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(this.index++);
            }
        };
    }
}
