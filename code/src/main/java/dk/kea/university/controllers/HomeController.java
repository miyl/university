package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.security.CustomUserPrincipal;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import dk.kea.university.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

// Security

// HomeController currently contains pages in the URL root like index, as well as mappings dealing with multiple data types (such as both Users and Courses)
@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        return "redirect:/courses/list";
    }

}
