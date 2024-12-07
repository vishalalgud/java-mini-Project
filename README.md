Sure! Let's expand the **Student Management System** (SMS) project by adding more features and demonstrating how to organize data, manage operations, and handle various functionalities. This system could include multiple features such as adding students, displaying information, updating student grades, removing students, searching students by roll number, and calculating averages.

### Key Features of the Student Management System:
1. **Add Student**: Add new student information.
2. **Remove Student**: Remove a student from the system by roll number.
3. **Display All Students**: List all students and their information.
4. **Search Student**: Search a student by roll number.
5. **Update Grade**: Modify the grade of a student.
6. **Calculate Average Grade**: Calculate the average grade of all students.

### Class Design:
1. **Student Class**: Represents a student.
2. **StudentManagement Class**: Manages the collection of students, handles operations like adding, removing, and displaying students.
3. **Main Class**: User interface for interacting with the system.

Let's implement each of these features in the project.

### 1. **Student Class**

The `Student` class holds the data for individual students, including their name, roll number, and grade.

```java
class Student {
    private String name;
    private int rollNumber;
    private double grade;

    // Constructor to initialize student data
    public Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getGrade() {
        return grade;
    }

    // Setter method to update grade
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Display student details
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}
```

### 2. **StudentManagement Class**

This class will manage the list of students and provide methods for adding, removing, updating, and displaying student data.

```java
import java.util.ArrayList;

class StudentManagement {
    private ArrayList<Student> students;

    // Constructor to initialize student list
    public StudentManagement() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " has been added.");
    }

    // Remove a student by roll number
    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student with roll number " + rollNumber + " has been removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                student.displayStudentInfo();
                System.out.println("--------------");
            }
        }
    }

    // Search student by roll number
    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.displayStudentInfo();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Update grade of a student
    public void updateGrade(int rollNumber, double newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setGrade(newGrade);
                System.out.println("Grade updated for student with roll number " + rollNumber);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Calculate average grade of all students
    public void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average grade.");
            return;
        }
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        double average = total / students.size();
        System.out.println("Average grade of all students: " + average);
    }
}
```

### 3. **Main Class**

The `Main` class will serve as the entry point to interact with the system. It will provide a simple menu for the user to perform actions like adding a student, displaying students, and so on.

```java
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
                case 1: // Add Student
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    Student student = new Student(name, rollNumber, grade);
                    management.addStudent(student);
                    break;

                case 2: // Remove Student
                    System.out.print("Enter roll number to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    management.removeStudent(removeRollNumber);
                    break;

                case 3: // Display All Students
                    management.displayAllStudents();
                    break;

                case 4: // Search Student
                    System.out.print("Enter roll number to search: ");
                    int searchRollNumber = scanner.nextInt();
                    management.searchStudent(searchRollNumber);
                    break;

                case 5: // Update Grade
                    System.out.print("Enter roll number to update grade: ");
                    int updateRollNumber = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGrade = scanner.nextDouble();
                    management.updateGrade(updateRollNumber, newGrade);
                    break;

                case 6: // Calculate Average Grade
                    management.calculateAverageGrade();
                    break;

                case 7: // Exit
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
```

### Explanation of Features:

- **Add Student**: Adds a student with their name, roll number, and grade to the system.
- **Remove Student**: Removes a student by their roll number. If the student is not found, it informs the user.
- **Display All Students**: Displays all students with their name, roll number, and grade.
- **Search Student**: Searches for a student by their roll number and displays their details.
- **Update Grade**: Allows updating the grade of a student by their roll number.
- **Calculate Average Grade**: Computes the average grade of all students in the system.

### Sample Output:

```
--- Student Management System ---
1. Add Student
2. Remove Student
3. Display All Students
4. Search Student by Roll Number
5. Update Grade
6. Calculate Average Grade
7. Exit
Enter your choice: 1
Enter name: Alice
Enter roll number: 101
Enter grade: 90

Student Alice has been added.

--- Student Management System ---
1. Add Student
2. Remove Student
3. Display All Students
4. Search Student by Roll Number
5. Update Grade
6. Calculate Average Grade
7. Exit
Enter your choice: 3

Name: Alice
Roll Number: 101
Grade: 90.0
--------------
```

### Possible Improvements:
- **Save Data to File**: Save and load student data from a file to make the system persistent.
- **Error Handling**: Add input validation (e.g., check for invalid grades, negative roll numbers, etc.).
- **Multiple Courses**: Extend the system to manage multiple courses for each student.
- **Graphical User Interface (GUI)**: Implement a graphical interface for easier interaction (using JavaFX or Swing).

This enhanced system covers a wide range of operations and is a great example of using object-oriented principles like encapsulation, inheritance, and methods in Java.
