package dk.kea.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  // Front page before having logged in
  @GetMapping("/")
  public String index(){
    return "index";
  }

  // Front page after having logged in
  @GetMapping("/overview")
  public String overview(){
    return "overview";
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @PostMapping("/login")
  public String plogin(){
    return "redirect:/overview";
  }

  @GetMapping("/register")
  public String register(){
    return "register";
  }

  @PostMapping("/register")
  public String pregister(){
    return "redirect:/login";
  }
  
}
