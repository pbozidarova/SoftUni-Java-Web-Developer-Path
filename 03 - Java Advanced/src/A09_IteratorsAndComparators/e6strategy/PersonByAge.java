package A09_IteratorsAndComparators.e6strategy;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class PersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        return f.getAge() - s.getAge();
    }

}
