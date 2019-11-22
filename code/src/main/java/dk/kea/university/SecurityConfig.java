package dk.kea.university;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// H2 console
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// This file can be anywhere in the project. The class name can be whatever, as long as it extends WebSecurityConfigurerAdapter.

@Configuration
@EnableWebSecurity
// This is method based security, there's also URL based security
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // These roles are the ones that must match the ones specified with @Secured in the Controllers. The Enum is irrelevant?
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("max").password(passwordEncoder().encode("p")).roles("STUDENT")
      .and()
      .withUser("eve").password(passwordEncoder().encode("p")).roles("TEACHER")
      .and()
      .withUser("sskraek").password(passwordEncoder().encode("p")).roles("TEACHER")
      .and()
      .withUser("hacker").password(passwordEncoder().encode("p")).roles("ADMIN");
  }

  // Spring Security blocks access to the console so therefore we have this section
  // https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/").permitAll().and()
      .authorizeRequests().antMatchers("/console/**").permitAll();
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
