package dk.kea.university.services;

import dk.kea.university.models.Course;
import dk.kea.university.repositories.ReCourse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Not used yet but may prove relevant
import java.util.List;
import java.util.Optional;

@Service
public class SeCourse {

    private ReCourse reCourse;

    // Not using Autowired to prevent construction of objects via reflection as that may result in objects not passing the constraint/constructor checks.
    public SeCourse(ReCourse reCourse) {
        this.reCourse = reCourse;
    }

    public int add(Course c) {
      Course saved = reCourse.save(c);
      return saved.getId();
    }

    public List<Course> list() {
      return reCourse.fetchAll();
    }

    public Course findCourse(int id) {
      Optional<Course> optional = reCourse.findById(id);
      if (optional.isPresent()) {
        return optional.get();
      } else {
        throw new IllegalArgumentException("No course with id: " + id);
      }
    }

    // TODO: Update and Delete
  
}
