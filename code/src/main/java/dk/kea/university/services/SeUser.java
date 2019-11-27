package dk.kea.university.services;

import dk.kea.university.models.User;
import dk.kea.university.repositories.ReUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dk.kea.university.models.UserRole.ROLE_TEACHER;

@Service
public class SeUser {

    private ReUser reUser;

    public SeUser(ReUser reUser) {
      this.reUser = reUser;
    }

    public long add(User u) {
      User saved = reUser.save(u);
      return saved.getId();
    }

    public List<User> teachers() {
        Iterable<User> allUsers = list();
        List<User> teachers = new ArrayList<>();
        for (User a : allUsers) {
            if(a.getRole() == ROLE_TEACHER) {
                teachers.add(a);
            }
        }
        return teachers;
    }

    // CrudRepository findAll returns an Iterable rather than a List, unlike JpaRepository findAll which returns a List
    public Iterable<User> list() {
      return reUser.findAll();
    }

    public User findUser(long id) {
      Optional<User> optional = reUser.findById(id);
      if (optional.isPresent()) {
        return optional.get();
      } else {
        throw new IllegalArgumentException("No course with id: " + id);
      }
    }
    public User findUserByName(String name){
        return reUser.findByUsername(name);
    }
    public void save(User user){
        reUser.save(user);
    }
}
