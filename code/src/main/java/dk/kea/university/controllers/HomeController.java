package dk.kea.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
public class HomeController {

  @GetMapping("/")
  public String list(){
    return "redirect:/courses/list";
  }
}
