package dk.kea.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  // As long as we keep these files in templates/home this seems sensible?
  String pathPrefix = "home/";

  // Front page before having logged in
  @GetMapping("/")
  public String index(){
    return pathPrefix + "index";
  }

  // Front page after having logged in
  @GetMapping("/overview")
  public String overview(){
    return pathPrefix + "overview";
  }

  @GetMapping("/login")
  public String login(){
    return pathPrefix + "login";
  }

  @PostMapping("/login")
  public String plogin(){
    return "redirect:/overview";
  }

  @GetMapping("/register")
  public String register(){
    return pathPrefix + "register";
  }

  @PostMapping("/register")
  public String pregister(){
    return "redirect:/login";
  }
  
}
