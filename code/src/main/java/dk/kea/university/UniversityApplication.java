package dk.kea.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        // System.out.println( new org.springframework.security.crypto.password.StandardPasswordEncoder().encode("p") );
        // System.out.println( "BCrypt:" );
        // System.out.println( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("p") );
        SpringApplication.run(UniversityApplication.class, args);
        System.out.println("Student: max");
        System.out.println("Teacher: eve");
        System.out.println("Teacher: neve");
        System.out.println("Admin: hacker");
        System.out.println("The password is 'p' for all of them.");
    }

}
