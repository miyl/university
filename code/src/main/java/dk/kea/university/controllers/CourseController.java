package dk.kea.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("courses")
public class CourseController {

  @GetMapping("/")
  public String list(){
    return "courseList";
  }

  @GetMapping("/add")
  public String add(){
    return "courseAdd";
  }

  @PostMapping("/add")
  public String add(){
    return "redirect:/add";
  }

  @GetMapping("/update")
  public String update(){
    return "courseAdd";
  }

  @PostMapping("/update")
  public String pupdate(){
    return "redirect:/";
  }

  @PostMapping("/delete")
  public String delete(){
    return "redirect:/";
  }
  
}
