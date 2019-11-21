package dk.kea.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
    System.out.println("TEST LOGINS ARE:");
    System.out.println("Student: max");
    System.out.println("Teacher: eve");
    System.out.println("Teacher: sskraek");
    System.out.println("Admin: hacker");
    System.out.println("The password is 'p' for all of them.");
	}

}
