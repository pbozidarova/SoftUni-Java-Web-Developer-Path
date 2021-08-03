package OOP03_Encapsulation.l04team;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;


    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        this.setSalary(salary);
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First name");

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last name");

        this.lastName = lastName;
    }

    private void validateName(String name, String value){
        if(name.length() < 3){
            throw new IllegalArgumentException(value + " must be at least 3 symbols");
        }

    }


    public void setAge(int age) {
        if(age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }

        this.age = age;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }

        this.salary = salary;
    }

    public void increaseSalary(double percentage){
        if(this.getAge() < 30){
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 200));
        }else {
            this.setSalary(this.getSalary() + (this.getSalary() * percentage / 100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
