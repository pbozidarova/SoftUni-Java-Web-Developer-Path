package course.springdata.mapping.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Double salary;
    @NonNull
    private LocalDate birthday;
    @NonNull
    @ManyToOne
    private Address address;

    private boolean onVacation;
    @ManyToOne(optional = true)
    @JoinColumn(name="manager_id", referencedColumnName = "id")
    private Employee manager;
    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates = new ArrayList<>();

}
