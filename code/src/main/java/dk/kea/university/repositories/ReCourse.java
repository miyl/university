package dk.kea.university.repositories;

import dk.kea.university.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCourse extends JpaRepository<Course, Integer> {

}

