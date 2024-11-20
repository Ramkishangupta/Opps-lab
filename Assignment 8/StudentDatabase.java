package ass8;

import java.io.*;
import java.util.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int studentId;
    String name;
    int rollNo;
    String className;
    double marks;
    String address;

    public Student(int studentId, String name, int rollNo, String className, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.marks = marks;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Roll No: " + rollNo + 
                ", Class: " + className + ", Marks: " + marks + ", Address: " + address;
    }
}

public class StudentDatabase {

    private static final String FILE_NAME = "students.db";

    public static void createDatabase() throws IOException {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many students do you want to add? ");
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1));
            
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            System.out.print("Enter Class: ");
            String className = scanner.nextLine();
            
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            
            students.add(new Student(studentId, name, rollNo, className, marks, address));
        }
        
        writeToFile(students);
        System.out.println("Database created with " + n + " student(s).");
    }


    private static void writeToFile(List<Student> students) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        }
    }

    // Method to read student list from file
    private static List<Student> readFromFile() throws IOException, ClassNotFoundException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        }
    }

    public static void displayDatabase() throws IOException, ClassNotFoundException {
        List<Student> students = readFromFile();
        if (students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to delete a student record by ID
    public static void deleteRecord(int studentId) throws IOException, ClassNotFoundException {
        List<Student> students = readFromFile();
        boolean removed = students.removeIf(student -> student.studentId == studentId);
        if (removed) {
            writeToFile(students);
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public static void updateRecord(int studentId, String name, int rollNo, String className, double marks, String address) throws IOException, ClassNotFoundException {
        List<Student> students = readFromFile();
        boolean updated = false;
        for (Student student : students) {
            if (student.studentId == studentId) {
                student.name = name;
                student.rollNo = rollNo;
                student.className = className;
                student.marks = marks;
                student.address = address;
                updated = true;
                break;
            }
        }
        if (updated) {
            writeToFile(students);
            System.out.println("Record updated.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public static void searchRecord(int studentId) throws IOException, ClassNotFoundException {
        List<Student> students = readFromFile();
        boolean found = false;
        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Record not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n---- Student Database Menu ----");
                System.out.println("1. Create Database");
                System.out.println("2. Display Database");
                System.out.println("3. Delete Record");
                System.out.println("4. Update Record");
                System.out.println("5. Search Record");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createDatabase();
                        break;
                    case 2:
                        displayDatabase();
                        break;
                    case 3:
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = scanner.nextInt();
                        deleteRecord(deleteId);
                        break;
                    case 4:
                        System.out.print("Enter Student ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter new Roll No: ");
                        int rollNo = scanner.nextInt();
                        scanner.nextLine();  // consume newline
                        System.out.print("Enter new class: ");
                        String className = scanner.nextLine();
                        System.out.print("Enter new marks: ");
                        double marks = scanner.nextDouble();
                        scanner.nextLine();  // consume newline
                        System.out.print("Enter new address: ");
                        String address = scanner.nextLine();
                        updateRecord(updateId, name, rollNo, className, marks, address);
                        break;
                    case 5:
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        searchRecord(searchId);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}