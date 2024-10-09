package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseEnrollment {

    List<Student> listOfStudents = new ArrayList<>();
    List<Course> listOfCourses = new ArrayList<>();

    HashMap<Integer, Student> studentMap = new HashMap<>();
    HashMap<Integer, Course> courseMap = new HashMap<>();

    public void addStudent(Student std){
        listOfStudents.add(std);
        studentMap.put(std.id, std);
    }

    public void addCourse(Course crs){
        listOfCourses.add(crs);
        courseMap.put(crs.courseId, crs);
    }


    public void enrollStudentInCourse(int studentId, int courseId) {

        Student student = studentMap.get(studentId);
        Course course = courseMap.get(courseId);

        if (student != null && course != null) {
            student.enrollmentCourses.add(course);
            System.out.println("Successfully enrolled " + student.name + " in " + course.courseName);
        } else {
            if (student == null) {
                System.out.println("Error: Student with ID " + studentId + " does not exist.");
            }
            if (course == null) {
                System.out.println("Error: Course with ID " + courseId + " does not exist.");
            }else
                System.out.println("Student and Course dose not exist");
        }
    }

    public void removeStudentFromCourse(int studentId, int courseId) {

        System.out.println("Method called");

        Student student = studentMap.get(studentId);
        System.out.println(student);
        Course course = courseMap.get(courseId);
        System.out.println(course);

        if (student != null && course != null) {
            if (listOfStudents.remove(student)) {
                student.enrollmentCourses.remove(course);
                System.out.println("Successfully removed " + student.name + " from " + course.courseName);
            }
        } else {
            if (student == null) {
                System.out.println("Error: Student with ID " + studentId + " does not exist.");
            }
            if (course == null) {
                System.out.println("Error: Course with ID " + courseId + " does not exist.");
            }else {
                System.out.println("Student not found in this course.");
            }
        }
    }

    public  void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("* * * List of All Students * * *");
        for (Student student : studentMap.values()) {
            System.out.println(student.toString());
        }
    }

    public  void displayAllCourses() {
//        System.out.println(courseMap);
        if (courseMap.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\"* * * List of All Courses * * *\"");
        for (Course course : courseMap.values()) {
            System.out.println(course.toString());
        }
    }




}
