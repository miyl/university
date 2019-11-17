package dk.kea.university.repositories;

import dk.kea.university.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReAuth extends JpaRepository<User, Integer> {
}
