package OOP02_Inheritance.l05stackstring;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){

    }

    public String pop(){
        if(!this.isEmpty()){
            return this.data.remove(this.data.size() -1);
        }

        return null;
    }

    public String peek(){
        if(!this.isEmpty()){
            return this.data.get(this.data.size() -1);
        }
        return null;
    }

    public boolean isEmpty(){
        return this. data.isEmpty();
    }




}
