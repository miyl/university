package dk.kea.university.controllers;

@Controller
@RequestMapping("courses")
public class CourseController {

    @GetMapping("/")
    public String showCourses(){
        return "courseList";
    }
  
}
