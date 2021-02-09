package course.springdata.advanced.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Shampoo> shampoos = new HashSet<>();
}
