package A09_IteratorsAndComparators.e6strategy;

import java.util.Comparator;

public class PersonByName implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result;


        result = f.getName().toUpperCase().compareTo(s.getName().toUpperCase());

        if(result == 0){
            result = f.getName().length() - s.getName().length();
        }
        return result;
    }
}
