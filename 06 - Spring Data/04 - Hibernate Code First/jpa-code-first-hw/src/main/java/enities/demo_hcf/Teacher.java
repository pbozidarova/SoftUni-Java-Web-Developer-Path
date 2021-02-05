package enities.demo_hcf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    private String speciality;

    public Teacher() {
    }

    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public Teacher setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

}
