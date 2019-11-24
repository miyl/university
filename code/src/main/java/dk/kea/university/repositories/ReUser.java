package dk.kea.university.repositories;

import dk.kea.university.models.User;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// TODO: We're using JpaRepository instead of CrudRepository because?
// TODO: Spring Security Guide here uses JpaRepository, in case of errors: https://www.baeldung.com/spring-security-authentication-with-a-database
@Repository
public interface ReUser extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
