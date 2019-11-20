package dk.kea.university.controllers;

import dk.kea.university.services.SeCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping("courses")
public class CourseController {



  // CRUD

  @GetMapping("/")
  public String list(){
    return "listCourses";
  }

  // These roles must match the ones specified in SecurityConfig.java
  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @GetMapping("/add")
  public String add(){
    return "addCourse";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @PostMapping("/add")
  public String padd(){
    return "redirect:/addCourse";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @GetMapping("/update")
  public String update(){
    return "updateCourse";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @PostMapping("/update")
  public String pupdate(){
    return "redirect:/";
  }

  //@Secured({"ROLE_ADMIN"})
  @PostMapping("/delete")
  public String delete(){
    return "redirect:/";
  }

}
