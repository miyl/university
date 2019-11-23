package dk.kea.university.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        return "redirect:/courses/list";
    }

    String prefixPath = "/home/";

    // TODO: I guess we need a separate Model for these? And a template.
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/student-signup-requests")
    public String studentSignupRequests() {
        return prefixPath + "student-signup-requests";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/student-signup-requests")
    public String pstudentSignupRequests() {
        return "redirect:/student-signup-requests";
    }

    // A list of "My" courses, ie. the courses you're in as a Student, or assigned to as a Teacher.
    @Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
    @GetMapping("/my")
    public String my() {
        return prefixPath + "my";
    }

}
