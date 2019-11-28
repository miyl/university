package dk.kea.university.services;

import dk.kea.university.models.Course;
import dk.kea.university.repositories.ReCourse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeCourse {

    private ReCourse reCourse;

    // Not using Autowired to prevent construction of objects via reflection as that may result in objects not passing the constraint/constructor checks.
    public SeCourse(ReCourse reCourse) {
        this.reCourse = reCourse;
    }

    public int add(Course c) {
        return reCourse.save(c).getId();
    }

    // CrudRepository findAll returns an Iterable rather than a List, unlike JpaRepository findAll which returns a List
    public Iterable<Course> list() {
        return reCourse.findAll();
    }

    //TODO: Rename to find
    public Course find(int id) {
        Optional<Course> optional = reCourse.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException("No course with id: " + id);
        }
    }

    //update method
    public void update(int id, Course course) {
        Optional<Course> optional = reCourse.findById(id);
        if (optional.isPresent()) {
            Course existing = optional.get();
            existing.setName_da(course.getName_da());
            existing.setName_en(course.getName_en());
            existing.setSemester(course.getSemester());
            existing.setClass_code(course.getClass_code());
            existing.setStudy_programme(course.getStudy_programme());
            existing.setMandatory_or_elective(course.getMandatory_or_elective());
            existing.setEcts(course.getEcts());
            existing.setCourse_language(course.getCourse_language());
            existing.setMin_students(course.getMin_students());
            existing.setMax_students(course.getMax_students());
            existing.setExpected_students(course.getExpected_students());
            existing.setPrerequisites(course.getPrerequisites());
            existing.setLearning_outcome(course.getLearning_outcome());
            existing.setContent(course.getContent());
            existing.setLearning_activities(course.getLearning_activities());
            existing.setExam_form(course.getExam_form());
            reCourse.save(existing);
        } else {
            throw new IllegalArgumentException("No Course with id: " + id);
        }
    }

    public void delete(int id) {
        //Sletter eksisterende produkt
        reCourse.deleteById(id);
    }

    public void save(Course course) {
        reCourse.save(course);
    }

}
