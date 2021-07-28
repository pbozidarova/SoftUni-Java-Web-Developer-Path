package A08_Generics.lab;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> elements;

    public Jar() {
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public T remove(){
        return this.elements.remove(this.elements.size() - 1);
    }

}
