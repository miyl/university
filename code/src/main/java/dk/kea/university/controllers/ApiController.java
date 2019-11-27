package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.security.CustomUserPrincipal;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import dk.kea.university.models.User;
import dk.kea.university.swagger.SeSwagger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

// HomeController currently contains pages in the URL root like index, as well as mappings dealing with multiple data types (such as both Users and Courses)
@RestController
@RequestMapping("api")
public class ApiController {

  private final SeUser seUser;
  private final SeCourse seCourse;
  private final SeSwagger seSwagger;

  public ApiController(SeUser u, SeCourse c, SeSwagger s) {
    this.seUser = u;
    this.seCourse = c;
    this.seSwagger = s;
  }

  @GetMapping("/list-courses")
  public Iterable<Course> list() {
    return seCourse.list();
  }


  /* SWAGGER: */

  @GetMapping("/swagger/list-courses")
  public Iterable<Course> listSwagger() {
    return seSwagger.listAll();
  }
}
