package student;

import java.util.Scanner;

public class StudentRunner {

    static Scanner input = new Scanner(System.in);
    static CourseEnrollment enrollmentObj = new CourseEnrollment();

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
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void addStudent(){

        System.out.print("Enter Student Id: ");
        int id = input.nextInt();
        System.out.print("Enter Student Name: ");
        String name = input.nextLine();
        System.out.print("Enter Student Email: ");
        String email = input.nextLine();
        System.out.print("Enter Student Phone Number: ");
        int phoneNumber = input.nextInt();
        System.out.print("Enter Student Major: ");
        String major = input.nextLine();

        Student student = new UndergraduateStudent(id, name, email, phoneNumber, major);
        enrollmentObj.addStudent(student);
        System.out.println("Student added successfully.");
//        System.out.println(enrollmentObj.listOfStudents);

    }

    public static void addCourse(){

        System.out.print("Enter Course Id: ");
        int id = input.nextInt();
        System.out.print("Enter Course Name: ");
        String name = input.nextLine();
        System.out.print("Enter Course Credit: ");
        double credit = input.nextDouble();
        System.out.print("Enter Course Grade: ");
        char grade = input.next().charAt(0);

        Course course = new MandatoryCourse(id, name, credit, grade);
        enrollmentObj.addCourse(course);
        System.out.println("Course added successfully.");
//        System.out.println(enrollmentObj.listOfCourses);

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


    public static void calculateStudentGPA(){

    }
}
