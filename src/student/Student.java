package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    int id;
    String name;
    String email;
    int phoneNumber;
    List<Course> enrollmentCourses;

    Student(int id, String name, String email, int phoneNumber){
        this.id = id;
        this.name = name;
        this.email = email;
        this. phoneNumber = phoneNumber;
        this.enrollmentCourses = new ArrayList<>();
    }

        @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", enrollmentCourses=" + enrollmentCourses +
                '}';
    }

    public void enrollCourse(Course course) {
        if (!enrollmentCourses.contains(course)) {
            enrollmentCourses.add(course);
        }
    }

    public void removeCourse(Course course) {
        enrollmentCourses.remove(course);
    }
}
