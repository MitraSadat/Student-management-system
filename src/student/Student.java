package student;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {

    private int id;
    private String name;
    private String email;
    private long phoneNumber;
    private List<Course> enrollmentCourses;
    private boolean isGraduate;

    Student(int id, String name, String email, long phoneNumber, boolean isGraduate){
        this.id = id;
        this.name = name;
        this.email = email;
        this. phoneNumber = phoneNumber;
        this.isGraduate = isGraduate;
        this.enrollmentCourses = new ArrayList<>();
    }

    private void setId(int id) { this.id = id;}
    private void setName(String name) { this.name = name;}
    private void setEmail(String email) { this.email = email;}
    private void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber;}
    private void setGraduate(boolean graduate) {isGraduate = graduate;}
    private void setEnrollmentCourses(List<Course> enrollmentCourses) { this.enrollmentCourses = enrollmentCourses;}

    public int getId() { return id;}
    public String getName() { return name;}
    public String getEmail() { return email;}
    public long getPhoneNumber() { return phoneNumber;}
    public boolean getIsGraduate() { return isGraduate;}
    public List<Course> getEnrollmentCourses() { return enrollmentCourses;}

    @Override
    public String toString() {
        return "Id : " + getId() +
                ", Name : " + getName()  +
                ", Email : " + getEmail()  +
                ", Phone Number : " + getPhoneNumber() +
                ", Is Graduate : " + getIsGraduate()  +
                ", Enrolled Courses=" + getEnrollmentCourses().toString();
    }

    public void enrollCourse(Course course) {
        if (!getEnrollmentCourses().contains(course)) {
            getEnrollmentCourses().add(course);
        }
    }

    public double calculateGPA() {
        double totalPoints = 0.0;
        double totalCredits = 0.0;

        for (Course course : getEnrollmentCourses()) {
            totalCredits += course.getCredits();
            totalPoints += convertGradeToPoints(course.getGrade()) *  course.getCredits();
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
