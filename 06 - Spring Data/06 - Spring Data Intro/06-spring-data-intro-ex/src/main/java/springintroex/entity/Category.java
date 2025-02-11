package springintroex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    private String name;

    private Set<Book> books;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Book> getBooks() {
        return books;
    }

    public Category setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }
}