package student;


import java.util.ArrayList;
import java.util.List;

public class Course {

    private int courseId;
    private String courseName;
    private double credits;
    private char grade;
    private boolean isMandatoryCourse;
    private List <Student> listOfStudents;


    public Course(int courseId, String courseName, double credits, char grade, boolean isMandatoryCourse) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
        this.isMandatoryCourse = isMandatoryCourse;
        List <Student> listOfStudents = new ArrayList<>();
    }

    private void setCourseId(int courseId) { this.courseId = courseId;}
    private void setCourseName(String courseName) { this.courseName = courseName;}
    private void setCredits(double credits) { this.credits = credits;}
    private void setGrade(char grade) { this.grade = grade;}
    private void setIsMandatoryCourse(boolean isMandatoryCourse) { this.isMandatoryCourse = isMandatoryCourse;}
    private void setListOfStudents(List<Student> listOfStudents) { this.listOfStudents = listOfStudents;}

    public int getCourseId() { return courseId;}
    public String getCourseName() { return courseName;}
    public double getCredits() { return credits;}
    public char getGrade() {return grade;}
    public boolean getIsMandatoryCourse() { return isMandatoryCourse;}
    public List<Student> getListOfStudents() { return listOfStudents;}

    @Override
    public String toString() {
        return  "Course Id : " + getCourseId() +
                ", Course Name : " + getCourseName() +
                ", Credits : " + getCredits() +
                ", Grade : " + getGrade() +
                ", Is Mandatory : " + getIsMandatoryCourse() +
                ", List Of Students : " + getListOfStudents();
    }

    public void addStudent(Student student){

        if(listOfStudents.contains(student)){
            System.out.println("Student is already enrolled in " + getCourseName() + " Course");
        }else{
            listOfStudents.add(student);
            System.out.println("Student added to the " + getCourseName() + " Course");
        }
    }


}
