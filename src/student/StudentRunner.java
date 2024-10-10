package student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRunner {

    static Scanner input = new Scanner(System.in);
    static CourseEnrollment enrollmentObj = new CourseEnrollment();
    static String fileName = "student.txt";

    public static void main(String[] args) {

        int choice;

       do{
           displayMenu();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudentInCourse();
                    break;
                case 4:
                    removeStudentFromCourse();
                    break;
                case 5:
                    enrollmentObj.displayAllStudents();
                    break;
                case 6:
                    enrollmentObj.displayAllCourses();
                    break;
                case 7:
                    calculateStudentGPA();
                    break;
                case 8:
                    searchStudentsById();
                    break;
                case 9:
                    searchCoursesById();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

    } while (choice != 0);

    }

    public static void displayMenu() {
        System.out.println("\n* * * * Student Management System * * * *");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Enroll Student in Course");
        System.out.println("4. Remove Student From Course");
        System.out.println("5. List Of Students");
        System.out.println("6. List of Courses");
        System.out.println("7. Calculate Student GPA");
        System.out.println("8. Search Student By Id");
        System.out.println("9. Search Course By Id");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void addStudent(){

        String major = "";
        String graduationDate = "";
        Student student;

        System.out.print("Enter Student Id: ");
        int id = input.nextInt();
        System.out.print("Enter Student Name: ");
        String name = input.next();
        System.out.print("Enter Student Email: ");
        String email = input.next();
        System.out.print("Enter Student Phone Number: ");
        long phoneNumber = input.nextLong();
        System.out.print("Is Student Graduated? ");
        boolean isGraduate = stringToBoolean(input.next());
        if (isGraduate) {
            System.out.print("Enter Student Graduation Date: ");
            graduationDate = input.next();
            student = new GraduateStudent(id, name, email, phoneNumber, isGraduate, graduationDate);
        }else{
            System.out.print("Enter Student Major: ");
            major = input.next();
            student = new UndergraduateStudent(id, name, email, phoneNumber, isGraduate, major);
        }
        enrollmentObj.addStudent(student);
        System.out.println("Student added successfully.");
        writeStudentInfoInFile(fileName);
    }

    public static boolean stringToBoolean(String str) {
        return str != null && str.equalsIgnoreCase("yes");
    }

    public static void addCourse(){

        Course course;

        System.out.print("Enter Course Id: ");
        int id = input.nextInt();
        System.out.print("Enter Course Name: ");
        String name = input.next();
        System.out.print("Enter Course Credit: ");
        double credit = input.nextDouble();
        System.out.print("Enter Course Grade: ");
        char grade = input.next().charAt(0);
        System.out.println("Is a Mandatory Course? ");
        boolean isMandatoryCoursee = stringToBoolean(input.next());
        if (isMandatoryCoursee) {
            course = new MandatoryCourse(id, name, credit, grade, isMandatoryCoursee);
        }else{
            course = new ElectiveCourse(id, name, credit, grade, isMandatoryCoursee);
        }
        enrollmentObj.addCourse(course);
        System.out.println("Course added successfully.");
        writeStudentInfoInFile(fileName);

    }

    private static void enrollStudentInCourse() {
        System.out.print("Enter student ID: ");
        int studentId = input.nextInt();
        System.out.print("Enter course ID: ");
        int courseId = input.nextInt();

        enrollmentObj.enrollStudentInCourse(studentId, courseId);
    }

    public static void removeStudentFromCourse(){

        System.out.print("Enter student ID: ");
        int studentId = input.nextInt();
        System.out.print("Enter course ID: ");
        int courseId = input.nextInt();

        enrollmentObj.removeStudentFromCourse(studentId, courseId);
    }


    public static void calculateStudentGPA() {

        System.out.print("Enter student ID: ");
        int studentId = input.nextInt();
        Student student = enrollmentObj.studentMap.get(studentId);
        if (student != null) {
            System.out.println( student.calculateGPA()); // Call the calculateGPA method

        } else {
            System.out.println("Invalid student ID.");
            System.out.println("0.0");
        }
    }

    public static void writeStudentInfoInFile(String fileName){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Students:\n");
            for(Student student : enrollmentObj.studentMap.values()){
                writer.newLine();
                writer.write(student.toString());
            }
            writer.write("\nCourses:\n");
            for (Course course : enrollmentObj.courseMap.values()) {
                writer.write(course.toString() + "\n");
            }
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Student> searchStudentsById() {
        System.out.print("Enter Student Id: ");
        int id = input.nextInt();
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : enrollmentObj.studentMap.values()) {
            if (student.getId() == id) {
                foundStudents.add(student);
            }
        }
        System.out.println(foundStudents);
        return foundStudents;
    }

    public static List<Course> searchCoursesById() {
        System.out.print("Enter Course Id: ");
        int id = input.nextInt();
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : enrollmentObj.courseMap.values()) {
            if (course.getCourseId() == id) {
                foundCourses.add(course);
            }
        }
        System.out.println(foundCourses);
        return foundCourses;
    }

}
