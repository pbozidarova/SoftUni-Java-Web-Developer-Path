package A06_DefiningClasses.e09CatLady;

public class Cat {
    private String name;
    private String breed;
    private double skillValue;

    public Cat(String name, String breed, double skillValue) {
        this.name = name;
        this.breed = breed;
        this.skillValue = skillValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSkillValue() {
        return skillValue;
    }

    public void setSkillValue(double skillValue) {
        this.skillValue = skillValue;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {

        return String.format("%s %s %.2f",
                this.getBreed(),
                this.getName(),
                this.getSkillValue()
        );
    }
}
