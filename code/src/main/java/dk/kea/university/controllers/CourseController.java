package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.services.SeCourse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Security
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;


@Controller
@RequestMapping("courses")
public class CourseController {

    private final SeCourse seCourse;

    public CourseController(SeCourse seCourse) {
        this.seCourse = seCourse;
    }

    String pathPrefix = "/courses/";

    // CRUD

    // One can get a Principal directly from Spring automatically, but it seems to not be our home grown CustomUserPrincipal and thus it doesn't contain all the data we need.
    @GetMapping("/list")
    public String list(Model m) {

        m.addAttribute("courses", seCourse.list());
        return pathPrefix + "list";
    }

    @GetMapping("/info/{idc}")
    public String info(Model m, @PathVariable("idc") int id) {
        m.addAttribute("course", seCourse.findCourse(id));
        return pathPrefix + "info";
    }

    // These roles must match the ones specified in SecurityConfig.java if using those users or the ones assigned in the database if using a custom User class
    @Secured({"ROLE_TEACHER"})
    @GetMapping("/add")
    public String add() {
        return pathPrefix + "add";
    }

    @Secured({"ROLE_TEACHER"})
    @PostMapping("/add")
    public String padd(@ModelAttribute Course course) {
        seCourse.add(course);
        return "redirect:/";
    }

    // Should probably take a specific course as input? You get here by clicking edit on a specific on a course in the list you're responsible for as a teacher (there can be multiple)
    @Secured({"ROLE_TEACHER"})
    @GetMapping("/update/{idc}")
    public String update(@PathVariable("idc") int id, Model m) {
        m.addAttribute("course", seCourse.findCourse(id));
        return pathPrefix + "update";
    }

    @Secured({"ROLE_TEACHER"})
    @PostMapping("/update")
    public String pupdate(@ModelAttribute Course course) {
        seCourse.update(course);
        return "redirect:/";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        seCourse.delete(id);
        return "redirect:/";
    }

}
