import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Search Student by Roll Number");
            System.out.println("5. Update Grade");
            System.out.println("6. Calculate Average Grade");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    Student student = new Student(name, rollNumber, grade);
                    management.addStudent(student);
                    break;

                case 2: 
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    management.removeStudent(removeRollNumber);
                    break;

                case 3:
                    management.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    management.searchStudent(searchRollNumber);
                    break;

                case 5:
                    System.out.print("Enter roll number to update grade: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    management.updateGrade(updateRollNumber, newGrade);
                    break;

                case 6:
                    management.calculateAverageGrade();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
