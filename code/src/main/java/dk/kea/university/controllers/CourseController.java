package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import dk.kea.university.swagger.SeSwagger;

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
    private final SeSwagger seSwagger;
    private final SeUser seUser;

    public CourseController(SeCourse c, SeSwagger s, SeUser u) {
        this.seCourse = c;
        this.seSwagger = s;
        this.seUser = u;
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
    public String add(Model model) {
        model.addAttribute("teachers", seUser.teachers());
        return pathPrefix + "add";
    }

    @Secured({"ROLE_TEACHER"})
    @PostMapping("/add")
    public String padd(@ModelAttribute Course course) {
        int id = seCourse.add(course);
        return "redirect:" + pathPrefix + "info/" + id;
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
    public String pupdate(@RequestParam("id") int id, @ModelAttribute Course course) {
        seCourse.updateCourse(id, course);
        return "redirect:/courses/info/" + id;
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        seCourse.delete(id);
        return "redirect:/";
    }

    @GetMapping("/swagger-test")
    public String swaggerTest() {
        seSwagger.listAll();
        // Returning some random template for now. Just run for its console output
        return pathPrefix + "add";
    }

}
