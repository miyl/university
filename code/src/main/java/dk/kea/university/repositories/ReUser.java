package dk.kea.university.repositories;

import dk.kea.university.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReUser extends JpaRepository<User, Integer> {}
