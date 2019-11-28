package dk.kea.university.swagger;

import dk.kea.university.models.Course;
//import dk.kea.university.repositories.ReCourse;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

// Make HTTP request and handle server response
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

// Thoughts: Should this return SwaggerCourses or handle converting back and forth between Course and SwaggerCourse (the Swagger representation of a course, which has less fields) as well?
@Service
public class SeSwagger {

  private RestTemplate restTemplate;
  private String swaggerBaseUrl = "http://35.159.46.191";

  public SeSwagger() {
    restTemplate = new RestTemplate();
  }

  // Look into: ResponseEntity vs. getForObject?
  public List<Course> list() {
    ResponseEntity<SwaggerCourse[]> response = restTemplate.getForEntity(swaggerBaseUrl + "/course", SwaggerCourse[].class);
    List<Course> cs = new ArrayList<Course>();

    for (var s : response.getBody()) {
      cs.add( new Course(s) );
      System.out.println(s);
    }

    return cs;
  }

  // Will return a Course object with only some fields set, ie. those found on Swagger. Should we use a custom model for this?
  public Course findById(int id) {
    SwaggerCourse s = restTemplate.getForObject(swaggerBaseUrl + "/course/" + id, SwaggerCourse.class);
    return new Course(s);
  }

  public void add(Course c) {
    // System.out.println(new SwaggerCourse(c));
    ResponseEntity<SwaggerCourse> response = restTemplate.postForEntity(swaggerBaseUrl + "/course", new SwaggerCourse(c), SwaggerCourse.class);
    // System.out.println(response.getStatusCode());
  }

  // Send DELETE
  public void delete(int id) {
    restTemplate.delete(swaggerBaseUrl + "/course/" + id);
  }

  // Really we need to distinguish between replacing an object (HTTP UPDATE) and changing parts of it (HTTP PATCH).
  public void update(int id, Course c) {
    SwaggerCourse s = new SwaggerCourse(c);
    restTemplate.patchForObject(swaggerBaseUrl + "/course/" + id + "/patch", s, SwaggerCourse.class);
  }
}
