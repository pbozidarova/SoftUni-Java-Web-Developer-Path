package A06_DefiningClasses.e01OpinionPoll;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;

    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
