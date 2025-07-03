package app.v1.week2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== Please Enter Student Name ===");
            String name = scanner.nextLine();
            Student student = new Student(name);

            while (true) {
                System.out.println("\n=== Grade Management System ===");
                System.out.println("1. Add Subject to Student");
                System.out.println("2. View Subjects - Grades");
                System.out.println("3. View the GPA");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.print("Enter subject title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter the grade: ");
                        double grade = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the credits: ");
                        int creadits = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter the Teacher's name: ");
                        String teacherName = scanner.nextLine();
                        Subject subject = new Subject(title);
                        subject.setGrade(grade);
                        subject.setCredits(creadits);
                        subject.setTeacher(teacherName);
                        student.addSubject(subject);
                        System.out.print("The subject has been added\n");
                        break;
                    }
                    case 2:
                        student.viewSubjects();
                        break;
                    case 3:
                        student.viewGPA();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
    }
}