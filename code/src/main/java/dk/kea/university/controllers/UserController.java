package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.models.User;
import dk.kea.university.models.UserCourse;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import dk.kea.university.security.CustomUserPrincipal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import org.springframework.security.core.Authentication;

import java.util.*;

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
    Course course = seCourse.find(course_id);
    course.addPendingStudent(user);
    seCourse.save(course);
    return prefixPath + "signupOk";
  }

  //TODO: evt. vis hvor mange der currently er signed up til et kursus for bedre overblik.
  @Secured({"ROLE_ADMIN"})
  @GetMapping("/student-signup-requests")
  public String studentSignupRequests(Model m) {
    Iterable<Course> allCourses = seCourse.list();
    Set<UserCourse> userCourseList = new HashSet<>();

    for(Course c : allCourses){
      Set<User> userPendingList = c.getPendingStudents();
      for(User u : userPendingList){
        userCourseList.add(new UserCourse(u, c));
      }
    }
    m.addAttribute("userCourseList", userCourseList);

    return prefixPath + "student-signup-requests";
  }

  @Secured({"ROLE_ADMIN"})
  @PostMapping("/student-signup-requests")
  public String pstudentSignupRequests(@RequestParam("user_id") int user_id, @RequestParam("course_id") int course_id, @RequestParam("approvedeny") String approveOrdeny) {
    Course course = seCourse.find(course_id);
    User user = seUser.findUser(user_id);
    //remove from pendinglist
    course.removePendingStudent(user);

    //if approve add to student to course
    if(approveOrdeny.equals("approve")){
      course.addStudent(user);
      seCourse.save(course);
    }
    //else
    else {
      seCourse.save(course);
    }
    return "redirect:/" + prefixPath + "student-signup-requests";
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
