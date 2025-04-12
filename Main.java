package project2;

    import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add New Student");
            System.out.println("2. Add Grades");
            System.out.println("3. View Student Report");
            System.out.println("4. Delete Student");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    manager.addStudent(id, name);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextInt();
                    Student student = manager.findStudentById(id);
                    if (student != null) {
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter subject: ");
                        String subject = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        student.addGrade(subject, grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextInt();
                    student = manager.findStudentById(id);
                    if (student != null) {
                        System.out.println("Name: " + student.getName());
                        System.out.println("Grades:");
                        for (var entry : student.getGrades().entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        System.out.println("Average Grade: " + student.getAverageGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    id = scanner.nextInt();
                    if (manager.removeStudent(id)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("All Students:");
                    for (Student s : manager.getAllStudents()) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName());
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    break;



                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}

