package dk.kea.university.models;

public class UserCourse {

    public User user;
    public Course course;

    public UserCourse(User user, Course course){
        this.user = user;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
