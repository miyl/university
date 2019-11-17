package dk.kea.university.controllers;

@Controller
@RequestMapping("users")
public class UserController {

    @GetMapping("/")
    public String showUsers(){
        return "userList";
    }
  
}
