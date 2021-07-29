package A11_Exam.prep.healthyHeaven;

import java.awt.desktop.SystemSleepEvent;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name){
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad){
        this.data.add(salad);
    }

    public boolean buy(String name){
        int indexToRemove = -1;
        for (int i = 0; i < this.data.size(); i++) {
            String saladName = this.data.get(i).getName();
            if(saladName.equals(name)){
                indexToRemove = i;
                break;
                //this.data.remove(i);
            }
        }
        if(indexToRemove != -1){
            this.data.remove(indexToRemove);
        }
        return indexToRemove != -1;
    }

    public Salad getHealthiestSalad(){
        Salad helthiestSalad = null;
        int minCal = Integer.MAX_VALUE;
        for (Salad salad : data) {
            if(salad.getTotalCalories() < minCal)
            minCal = salad.getTotalCalories();
            helthiestSalad = salad;
        }
        return helthiestSalad;
    }

    public String generateMenu(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s have %d salads:", this.name, this.data.size()));
        sb.append(System.lineSeparator());
        for (Salad salad : data) {
            sb.append(salad.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
