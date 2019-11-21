package dk.kea.university.controllers;

import dk.kea.university.services.SeCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping("courses")
public class CourseController {

  private final SeCourse seCourse;

  public CourseController(SeCourse seCourse) {
    this.seCourse = seCourse;
  }

  String pathPrefix="courses/";

  // CRUD

  @GetMapping("/list")
  public String list(Model m){
    m.addAttribute("courses", seCourse.list());
    return pathPrefix + "list";
  }

  // These roles must match the ones specified in SecurityConfig.java
  @Secured({"ROLE_TEACHER"})
  @GetMapping("/add")
  public String add(){
    return pathPrefix + "add";
  }

  @Secured({"ROLE_TEACHER"})
  @PostMapping("/add")
  public String padd(){
    return "redirect:/add";
  }

  // Should probably take a specific course as input? You get here by clicking edit on a specific on a course in the list you're responsible for as a teacher (there can be multiple)
  @Secured({"ROLE_TEACHER"})
  @GetMapping("/update")
  public String update(){
    return pathPrefix + "update";
  }

  @Secured({"ROLE_TEACHER"})
  @PostMapping("/update")
  public String pupdate(){
    return "redirect:/";
  }

  @Secured({"ROLE_ADMIN"})
  @PostMapping("/delete")
  public String delete(){
    return "redirect:/";
  }

  // A list of "My" courses, ie. the courses you're in as a Student, or assigned to as a Teacher.
  @Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
  @GetMapping("/my")
  public String my() {
    return pathPrefix + "my";
  }

}
