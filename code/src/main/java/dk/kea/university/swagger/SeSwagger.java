package dk.kea.university.swagger;

import dk.kea.university.models.Course;
//import dk.kea.university.repositories.ReCourse;
//
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
  public List<Course> listAll() {
    ResponseEntity<SwaggerCourse[]> response = restTemplate.getForEntity(swaggerBaseUrl + "/course", SwaggerCourse[].class);
    // TODO: Create Course list from the SwaggerCourse list here. Put the conversion in a method so findCourseById can use it too?
    List<Course> cs = new ArrayList<Course>();

    for (var sc : response.getBody()) {
      // Course c = new Course();
      // c.setName_da(); ...and so forth
      System.out.println(sc);
    }

    return cs;
  }

  // Will return a Course object with only some fields set, ie. those found on Swagger. Should we use a custom model for this?
  public Course findCourseById(int id) {
    SwaggerCourse sc = restTemplate.getForObject(swaggerBaseUrl + "/course/" + id, SwaggerCourse.class);
    //SwaggerCourse sc =
    // TODO: Create a Course from the SwaggerCourse here
    return new Course();
  }

  public boolean addCourse(Course c) {
    //restTemplate.???(swaggerBaseUrl + "/course");
    return true;
  }

  // Send DELETE
  public boolean deleteCourse(int id) {
    //restTemplate.delete(swaggerBaseUrl + "/course/" + id);
    return true;
  }

  // Really we need to distinguish between replacing an object (HTTP UPDATE) and changing parts of it (HTTP PATCH).
  public int updateCourse(Course c) {
    // TODO: Create SwaggerCourse from Course here
    // = SwaggerCourse sc = restTemplate.patchForObject(swaggerBaseUrl + "/course/" + id + "/patch", sc, SwaggerCourse.class);
    return 0;
  }
}
