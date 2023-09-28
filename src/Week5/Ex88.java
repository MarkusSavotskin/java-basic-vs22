package Week5;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex88 {

    public static class Student {
        private String name;
        private String studentNumber;

        public Student(String name, String studentNumber) {
            this.name = name;
            this.studentNumber = studentNumber;
        }

        public String getName() {
            return name;
        }

        public String getStudentNumber() {
            return studentNumber;
        }


    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String enteredName;
        String enteredStudentNumber;
        String searchTerm;

        while (true) {
            System.out.print("Student name: ");
            enteredName = scanner.nextLine();

            if (enteredName.equals("")) {
                break;
            }
            System.out.print("Student number: ");
            enteredStudentNumber = scanner.nextLine();
            list.add(new Student(enteredName, enteredStudentNumber));

        }

        for (Student student : list) {
            System.out.println(student.getName() + " (" + student.getStudentNumber() + ")");
        }

        System.out.println();
        System.out.print("Give search term: ");
        searchTerm = scanner.nextLine();
        System.out.println("Result:");

        for (Student student : list) {
            if (student.getName().contains(searchTerm)) {
                System.out.println(student.getName() + " (" + student.getStudentNumber() + ")");
            }
        }
    }
}
