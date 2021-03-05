package bg.softuni.tabula.user;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")//USER is reserved in some DB-s, e.g. Postgresql
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  private long id;

  @NotNull
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password")
  private String passwordHash;

  @OneToMany(
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch= FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private List<RoleEntity> roles = new ArrayList<>();

  public UserEntity setId(long id) {
    this.id = id;
    return this;
  }

  public UserEntity setRoles(List<RoleEntity> roles) {
    this.roles = roles;
    return this;
  }

}
