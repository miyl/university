package dk.kea.university.controllers;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
  
}
