package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    int id;
    String name;
    String email;
    long phoneNumber;
    List<Course> enrollmentCourses;

    Student(int id, String name, String email, long phoneNumber){
        this.id = id;
        this.name = name;
        this.email = email;
        this. phoneNumber = phoneNumber;
        this.enrollmentCourses = new ArrayList<>();
    }

        @Override
    public String toString() {
        return "Id : " + id +
                ", Name : " + name  +
                ", Email : " + email  +
                ", Phone Number : " + phoneNumber +
                ", Enrolled Courses=" + enrollmentCourses.toString();
    }

    public void enrollCourse(Course course) {
        if (!enrollmentCourses.contains(course)) {
            enrollmentCourses.add(course);
        }
    }


    public double calculateGPA() {
        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (Course course : enrollmentCourses) {
            totalCredits += course.credits;
            totalPoints += convertGradeToPoints(course.grade) *  course.credits;
        }
        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    private double convertGradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            case 'F':
                return 0.0;
            default:
                return 0.0;
        }
    }
}
