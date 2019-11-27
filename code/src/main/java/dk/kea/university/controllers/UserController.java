package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.models.User;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import dk.kea.university.security.CustomUserPrincipal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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

  @Secured({"ROLE_ADMIN"})
  @GetMapping("/inCourse")
  public String usersInCourse(@PathVariable("courseId") int courseId) {
    //Iterable<User> usersInCourse = seUser.getUsersInCourse();
    return prefixPath + "inCourse";
  }

  // A student requests to sign up for a course. Done via the course list and possibly also info
  // Teachers sign up while adding a course or editing one.
  @Secured({"ROLE_STUDENT"})
  @PostMapping("/student-signup")
  public String signup(Principal p, @RequestParam("id") int course_id){

    User user = seUser.findUserByName(p.getName());
    Course course = seCourse.findCourse(course_id);
    course.setPendingStudents(user);
    seCourse.save(course);
    return prefixPath + "signupOk";
  }

  @Secured({"ROLE_ADMIN"})
  @GetMapping("/student-signup-requests")
  public String studentSignupRequests(Model m) {
    List<User> pendingList = new ArrayList<>();
    Iterable<Course> allCourses = seCourse.list();
    for(Course c : allCourses){
      Set<User> userPendingList = c.getPendingStudents();
      for(User u : userPendingList){
        pendingList.add(u);
        System.out.println("Added: " +  u.toString());
      }
    }
    m.addAttribute(pendingList);
    return prefixPath + "student-signup-requests";
  }

  @Secured({"ROLE_ADMIN"})
  @PostMapping("/student-signup-requests")
  public String pstudentSignupRequests() {
    return "redirect:/student-signup-requests";
  }

  // A list of "My" courses, ie. the courses you're in as a Student, or assigned to as a Teacher.
  @Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
  @GetMapping("/my")
  public String my(Authentication a, Model m) {
    CustomUserPrincipal p = (CustomUserPrincipal) a.getPrincipal();
    User currentUser = p.getUser();
    Iterable<Course>allCourses = seCourse.list();
    Set<Course>myCourses = new HashSet<>();

    for (var c : allCourses) {
      for (var u : c.getUsersFollowing()) {
        if (currentUser.equals(u)) {
          myCourses.add(c);
          break;
        }
      }
    }
    m.addAttribute("myCourses", myCourses);

    return prefixPath + "my";
  }


}
