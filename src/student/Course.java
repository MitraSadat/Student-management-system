package student;


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
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", grade=" + grade +
                '}';
    }

    public void addStudent(Student student){

        if(listOfStudents.contains(student)){
            System.out.println("Student is already enrolled in " + courseName + " Course");
        }else{
            listOfStudents.add(student);
            System.out.println("Student added to the " + courseName + " Course");
        }
    }

    public void removeStudent(Student student) {
        if (listOfStudents.remove(student)) {
//            student.removeCourse(this);
            System.out.println("Successfully removed " + student.name + " from " + courseName);
        } else {
            System.out.println("Student not found in this course.");
        }
    }


}
