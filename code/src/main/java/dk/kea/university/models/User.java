package dk.kea.university.models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

/**
 * Class that stores user-attributes.
 *
 * @Author Tariq and Marcus
 */

@Entity
public class User {

    // START: Spring Security related
    // NOTE: Spring Security counts on this particular order of fields (id, username, password) in the database for password authentication, like wtf!:
    // https://stackoverflow.com/questions/54448451/spring-security-cannot-determine-value-type-from-string-admin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
    // END: Spring Security related

    @Column(nullable = false)
    @NotBlank
    private String first_name;

    @Column(nullable = false)
    @NotBlank
    private String last_name;

    @Column(nullable = false)
    @NotBlank
    private String email;

    // Note: This is zero indexed. If you set a higher number than available in the db, login will fail.
    @NotNull
    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false)
    @NotBlank
    private Timestamp createdAt;

    @ManyToMany(mappedBy = "usersFollowing")
    private Set<Course> coursesFollowing;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole ur) {
        role = ur;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Course> getCoursesFollowing() {
        return coursesFollowing;
    }

    public void setCoursesFollowing(Set<Course> cf) {
        coursesFollowing = cf;
    }

    // Needed because they're sometimes stored in a Set
    public int hashCode() {
        return Objects.hash(id);
    }
}
