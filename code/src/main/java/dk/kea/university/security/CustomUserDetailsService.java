package dk.kea.university.security;

import dk.kea.university.repositories.ReUser;
import dk.kea.university.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

// Res:
// https://www.baeldung.com/spring-security-authentication-with-a-database
// https://github.com/eugenp/tutorials/blob/master/spring-security-mvc-boot/src/main/java/com/baeldung/security/CustomUserDetailsService.java
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private ReUser reUser;

    public CustomUserDetailsService(ReUser reUser) {
      this.reUser = reUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = reUser.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserPrincipal(user);
    }
}
