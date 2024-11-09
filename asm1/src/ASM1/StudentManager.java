package ASM1;

import java.util.*;

class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getRank() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRank();
    }
}

public class StudentManager {
    private LinkedList<Student> studentList = new LinkedList<>();

    // Thêm sinh viên mới
    public void addStudent(String id, String name, double marks) {
        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // Chỉnh sửa thông tin sinh viên
    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(String id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Tìm kiếm sinh viên theo ID
    public void searchStudent(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Sắp xếp sinh viên theo điểm
    public void sortStudentsByMarks() {
        studentList.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks:");
        displayAllStudents();
    }

    // Hiển thị toàn bộ danh sách sinh viên
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("Student List:");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    // Khởi tạo dữ liệu mẫu cho 10 sinh viên
    public void initializeSampleData() {
        addStudent("S001", "Alice", 8.5);
        addStudent("S002", "Bob", 6.8);
        addStudent("S003", "Charlie", 4.2);
        addStudent("S004", "David", 9.5);
        addStudent("S005", "Eve", 7.3);
        addStudent("S006", "Frank", 5.5);
        addStudent("S007", "Grace", 6.0);
        addStudent("S008", "Hank", 7.8);
        addStudent("S009", "Ivy", 9.1);
        addStudent("S010", "John", 3.9);
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo dữ liệu mẫu
        manager.initializeSampleData();

        while (true) {
            System.out.println("\n--- Student Manager Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter Student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    manager.searchStudent(searchId);
                    break;
                case 5:
                    manager.sortStudentsByMarks();
                    break;
                case 6:
                    manager.displayAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
