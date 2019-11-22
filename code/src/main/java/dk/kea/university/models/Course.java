package dk.kea.university.models;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * Class that holds Course attributes.
 *
 * @Author Tariq and Marcus
 */
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String name_da;

    @Column(nullable = false)
    @NotBlank
    private String name_en;

    @Column(nullable = false)
    @NotBlank
    private int semester;

    @Column(nullable = false)
    @NotBlank
    private String class_code;

    @Column(nullable = false)
    @NotBlank
    private String study_programme;

    @Column(nullable = false)
    @NotBlank
    private String mandatory_or_elective;

    @Column(nullable = false)
    @NotBlank
    private int ects;

    @Column(nullable = false)
    @NotBlank
    private String course_language;

    @Column(nullable = false)
    @NotBlank
    private int min_students;

    @Column(nullable = false)
    @NotBlank
    private int max_students;

    @Column(nullable = false)
    @NotBlank
    private int expected_students;

    @Column(nullable = false)
    @NotBlank
    private String prerequisites;

    @Column(nullable = false)
    @NotBlank
    private String learning_outcome;

    @Column(nullable = false)
    @NotBlank
    private String content;

    @Column(nullable = false)
    @NotBlank
    private String exam_form;

    @ManyToMany
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<User> usersFollowing;

    // Required by Spring
    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_da() {
        return name_da;
    }

    public void setName_da(String name_da) {
        this.name_da = name_da;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getStudy_programme() {
        return study_programme;
    }

    public void setStudy_programme(String study_programme) {
        this.study_programme = study_programme;
    }

    public String getMandatory_or_elective() {
        return mandatory_or_elective;
    }

    public void setMandatory_or_elective(String mandatory_or_elective) {
        this.mandatory_or_elective = mandatory_or_elective;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public int getMin_students() {
        return min_students;
    }

    public void setMin_students(int min_students) {
        this.min_students = min_students;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }

    public int getExpected_students() {
        return expected_students;
    }

    public void setExpected_students(int expected_students) {
        this.expected_students = expected_students;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLearning_outcome() {
        return learning_outcome;
    }

    public void setLearning_outcome(String learning_outcome) {
        this.learning_outcome = learning_outcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExam_form() {
        return exam_form;
    }

    public void setExam_form(String exam_form) {
        this.exam_form = exam_form;
    }

    // Needed because they're sometimes stored in a Set
    public int hashCode() {
        return Objects.hash(id);
    }
}
