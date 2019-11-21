package dk.kea.university.controllers;

import dk.kea.university.services.SeUser;
import dk.kea.university.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import java.lang.Iterable;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping("users")
public class UserController {

  private final SeUser seUser;
  String pathPrefix="users/";

  public UserController(SeUser seUser) {
    this.seUser = seUser;
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

}
