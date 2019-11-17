package dk.kea.university.services;

import dk.kea.university.models.User;
import dk.kea.university.repositories.ReUser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Not used yet but may prove relevant
import java.util.List;
import java.util.Optional;

@Service
public class SeUser {

    private ReUser reUser;

    public SeUser(ReUser reUser) {
      this.reUser = reUser;
    }

    public int add(User u) {
      User saved = reUser.save(u);
      return saved.getId();
    }

    public List<User> list() {
      return reUser.findAll();
    }

    public User findUser(int id) {
      Optional<User> optional = reUser.findById(id);
      if (optional.isPresent()) {
        return optional.get();
      } else {
        throw new IllegalArgumentException("No course with id: " + id);
      }
    }

    // TODO: Update and Delete
  
}
