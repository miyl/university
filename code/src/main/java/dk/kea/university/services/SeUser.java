package dk.kea.university.services;

import dk.kea.university.models.User;
import dk.kea.university.repositories.ReUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

  
}
