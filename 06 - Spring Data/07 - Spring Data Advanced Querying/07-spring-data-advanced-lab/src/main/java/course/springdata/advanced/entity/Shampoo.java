package course.springdata.advanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="shampoos")
public class Shampoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String brand;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    private SizeEnum size;
    @ManyToOne(optional = true)
    private Label label;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {PERSIST, REFRESH})
    @JoinTable(
            joinColumns = @JoinColumn(name="shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id", referencedColumnName = "id"))
    private Set<Ingredient> ingredients = new HashSet<>();

}