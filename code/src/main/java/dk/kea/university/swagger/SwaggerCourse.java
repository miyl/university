package dk.kea.university.swagger;

import dk.kea.university.models.User;
import dk.kea.university.models.Course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import java.util.stream.Collectors;

// If the server sends any JSON values not represented in this model, ignore them
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwaggerCourse {

  // This has the same values, names and order as the API representation
  private String description;
  private String ects;
  private int id;
  private String language;
  private boolean mandatory;
  private String name;
  private String namedanish;
  private int numberOfTeachers;
  private int semester;
  private String studyprogramme;

  public SwaggerCourse() {}

  public SwaggerCourse(String description, String ects, int id, String language, boolean mandatory, String name, String namedanish, int numberOfTeachers, int semester, String studyprogramme) {
    this.description = description;
    this.ects = ects;
    this.id = id;
    this.language = language;
    this.mandatory = mandatory;
    this.name = name;
    this.namedanish = namedanish;
    this.numberOfTeachers = numberOfTeachers;
    this.semester = semester;
    this.studyprogramme = studyprogramme;
  }

  // Easily create a SwaggerCourse from a Course - and vice versa in the Course model
  public SwaggerCourse(Course c) {
    this.description = c.getContent(); // Not sure what the Swagger documented API's description should map to in our model?
    this.ects =  String.valueOf( c.getEcts() ); // Swaggers ects is a String for some reason
    this.id = c.getId();
    this.language = c.getCourse_language();
    this.mandatory = ( c.getMandatory_or_elective().equals("mandatory") )? true : false;
    this.name = c.getName_en();
    this.namedanish = c.getName_da();
    this.numberOfTeachers = c.getUsersFollowing().stream().filter(u -> u.getRole().name().equals("ROLE_TEACHER")).collect(Collectors.toList()).size();
    this.semester = c.getSemester();
    this.studyprogramme = c.getStudy_programme();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEcts() {
    return ects;
  }

  public void setEcts(String ects) {
    this.ects = ects;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public boolean isMandatory() {
    return mandatory;
  }

  public void setMandatory(boolean mandatory) {
    this.mandatory = mandatory;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNamedanish() {
    return namedanish;
  }

  public void setNamedanish(String namedanish) {
    this.namedanish = namedanish;
  }

  public int getNumberOfTeachers() {
    return numberOfTeachers;
  }

  public void setNumberOfTeachers(int numberOfTeachers) {
    this.numberOfTeachers = numberOfTeachers;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public String getStudyprogramme() {
    return studyprogramme;
  }

  public void setStudyprogramme(String studyprogramme) {
    this.studyprogramme = studyprogramme;
  }

  @Override
  public String toString() {
    return "SwaggerCourse{" +
            "description='" + description + '\'' +
            ", ects='" + ects + '\'' +
            ", id=" + id +
            ", language='" + language + '\'' +
            ", mandatory=" + mandatory +
            ", name='" + name + '\'' +
            ", namedanish='" + namedanish + '\'' +
            ", numberOfTeachers=" + numberOfTeachers +
            ", semester=" + semester +
            ", studyprogramme='" + studyprogramme + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SwaggerCourse that = (SwaggerCourse) o;
    return id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
