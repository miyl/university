package dk.kea.university.repositories;

import dk.kea.university.models.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReCourse extends JpaRepository<Course, Integer> {}
