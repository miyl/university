package dk.kea.university.models;

// It seems Spring Security assumes these roles have the names ROLE_, otherwise the @Secured({"ROLE_TEACHER"}) don't work. Even if you change them to @Secured({"TEACHER"}).
// Same seemingly goes for sec_authorize in thymeleaf
public enum UserRole {
  ROLE_ADMIN, ROLE_TEACHER, ROLE_STUDENT
}
