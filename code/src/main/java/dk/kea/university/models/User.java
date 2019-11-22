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
 * @Author Tariq and Marcus
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String first_name;

    @Column(nullable = false)
    @NotBlank
    private String last_name;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String email;

    @NotNull
    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false)
    @NotBlank
    private Timestamp createdAt;

    @ManyToMany(mappedBy = "usersFollowing")
    private Set<Course> coursesFollowing;

    @ManyToMany(mappedBy = "usersTeaching")
    private Set<Course> coursesTeaching;

    public User(int id, String first_name, String last_name, String password, String email, UserRole role, Timestamp createdAt) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    // Required by Spring
    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserRole getUserRole() {
        return role;
    }

    public void setUserRole(UserRole ur) {
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

    public Set<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    public void setCoursesTeaching(Set<Course> cf) {
        coursesTeaching = cf;
    }

    // Needed because they're sometimes stored in a Set
    public int hashCode() {
        return Objects.hash(id);
    }
}
