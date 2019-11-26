package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.security.CustomUserPrincipal;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import dk.kea.university.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.lang.Iterable;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping("users")
public class UserController {

  private final SeUser seUser;
  private final SeCourse seCourse;
  String pathPrefix="users/";

  public UserController(SeUser seUser, SeCourse seCourse) {
    this.seUser = seUser;
    this.seCourse = seCourse;

  }

  //@GetMapping("/")
  //public String list(){
  //  return "userList";
  //}

  @Secured({"ROLE_ADMIN"})
  @GetMapping("/inCourse")
  public String usersInCourse(@PathVariable("courseId") int courseId) {
    //Iterable<User> usersInCourse = seUser.getUsersInCourse();
    return pathPrefix + "inCourse";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  // @GetMapping("/add")
  // public String add(){
  //   return "userAdd";
  // }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  // @PostMapping("/add")
  // public String padd(){
  //   return "redirect:/add";
  // }

  // @GetMapping("/update")
  // public String update(){
  //   return "userUpdate";
  // }

  // @PostMapping("/update")
  // public String pupdate(){
  //   return "redirect:/";
  // }

  // @PostMapping("/delete")
  // public String delete(){
  //   return "redirect:/";
  // }
  
  @GetMapping("/student-signup")
  public String signupPage(){
    return pathPrefix + "my";
  }

  @Secured({"ROLE_STUDENT"})
  @PostMapping("/student-signup")
  public String signup(Authentication a, @RequestParam("id") int course_id){
    CustomUserPrincipal p = (CustomUserPrincipal) a.getPrincipal();
    User user = p.getUser();

    Course course = seCourse.findCourse(course_id);
    user.addPendingCourse(course);

    return pathPrefix + "signupOk";
  }
}
