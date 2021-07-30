package A09_IteratorsAndComparators.e7equalitylogic;


public class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        int result;

        result = this.name.compareTo(other.name);

        if (result == 0) {
            result = this.age - other.age;
        }

        return result;
    }

    public boolean equals(Object other){
        if(this == (Person)other){
            return true;
        }

        if(other instanceof Person){
            if(this.name.equals(((Person) other).name) &&
            this.age.equals(((Person) other).age) ){
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + this.age.hashCode();
    }

}
