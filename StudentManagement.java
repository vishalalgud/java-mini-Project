import java.util.ArrayList;

class StudentManagement {
    private ArrayList<Student> students;
    public StudentManagement() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " has been added.");
    }
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
    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.displayStudentInfo();
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
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
