package student;


import java.util.ArrayList;
import java.util.List;

public class Course {

    int courseId;
    String courseName;
    double credits;
    char grade;
    List <Student> listOfStudents;


    public Course(int courseId, String courseName, double credits, char grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
        List <Student> listOfStudents = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  "Course Id : " + courseId +
                ", Course Name : " + courseName +
                ", Credits : " + credits +
                ", Grade : " + grade +
                ", List Of Students : " + listOfStudents;
    }

    public void addStudent(Student student){

        if(listOfStudents.contains(student)){
            System.out.println("Student is already enrolled in " + courseName + " Course");
        }else{
            listOfStudents.add(student);
            System.out.println("Student added to the " + courseName + " Course");
        }
    }


}
