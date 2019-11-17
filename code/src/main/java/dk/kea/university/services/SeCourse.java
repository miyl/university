package dk.kea.university.services;

import dk.kea.university.models.Course;
import dk.kea.university.repositories.ReCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SeCourse {

    private ReCourse reCourse;

    // Not using Autowired because...?
    public SeCourse(ReCourse reCourse) {
        this.reCourse = reCourse;
    }

    public int add(Course c) {
      Course saved = reCourse.save(c);
      return saved.getId();
    }
  
}
