package dk.kea.university.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dk.kea.university.models.User;

// Res:
// https://www.baeldung.com/spring-security-authentication-with-a-database
// https://github.com/eugenp/tutorials/blob/master/spring-security-mvc-boot/src/main/java/com/baeldung/security/AppUserPrincipal.java
public class CustomUserPrincipal implements UserDetails {

    private final User user;

    public CustomUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // We get our custom role here, which Spring Security in turn uses in the Controller, templates etc.:
        final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority( user.getRole().name() ));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
