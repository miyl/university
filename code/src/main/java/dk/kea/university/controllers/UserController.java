package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.models.User;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

// Security

@Controller
@RequestMapping("users")
public class UserController {

  private final SeUser seUser;
  private final SeCourse seCourse;
  String prefixPath="users/";

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
    return prefixPath + "inCourse";
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
    return prefixPath + "my";
  }

  @Secured({"ROLE_STUDENT"})
  @PostMapping("/student-signup")
  public String signup(Principal p, @RequestParam("id") int course_id){

    User user = seUser.findUserByName(p.getName());
    Course course = seCourse.findCourse(course_id);
    course.setPendingStudents(user);
    seCourse.save(course);
    return prefixPath + "signupOk";
  }

  // TODO: Do we need a separate Model for these? And a template. Or don't we?
  @Secured({"ROLE_ADMIN"})
  @GetMapping("/student-signup-requests")
  public String studentSignupRequests() {
    return prefixPath + "student-signup-requests";
  }

  @Secured({"ROLE_ADMIN"})
  @PostMapping("/student-signup-requests")
  public String pstudentSignupRequests() {
    return "redirect:/student-signup-requests";
  }

}
