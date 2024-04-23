package crud;

import crud.dao.StudentDAO;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();

    public static void menu(){
        System.out.println("---CRUD---");
        System.out.println("0. Search student");
        System.out.println("1. List student");
        System.out.println("2. Add student");
        System.out.println("3. Show student");
        System.out.println("4. Delete student");
        System.out.println("----------------");
        System.out.print("Chose number: ");
    }

    public static void searchStudent() throws Exception {
        System.out.print("Enter student name: ");
        String inputSearch = scanner.next().trim();

        if (inputSearch.isEmpty()) {
            inputSearch = null;
        }

        List<Student> listSearch = studentDAO.getAllStudent(inputSearch);

        if (inputSearch != null) {
            System.out.println("Students containing \"" + inputSearch + "\" in their names:");
        } else {
            System.out.println("All students:");
        }

        System.out.println("==============================");
        for (Student student : listSearch) {
            System.out.println(student);
        }
        System.out.println("==============================");
    }

    public static void listStudent() throws Exception {
        List<Student> list = studentDAO.getAllStudent(null);
        System.out.println("==============================");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("==============================");
    }

    public static void addStudent() throws Exception {
        System.out.println("==============================");
        System.out.println("Add new student");

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Gender: ");
        int gender = scanner.nextInt();

        System.out.print("Dob: ");
        String dob = scanner.next();

        studentDAO.addStudent(name, gender, dob);

        System.out.println("==============================");
    }

    public static void showStudent() throws Exception {
        System.out.println("==============================");
        System.out.print("You want to show student information with id: ");

        int editId = scanner.nextInt();
        Student student = studentDAO.getStudentById(editId);

        String sex = student.getGender() == 1 ? "Male" : "Female";

        System.out.println("Student information:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Gender: " + sex);
        System.out.println("Date of Birth: " + student.getDob());

        System.out.println("------------------------------");

        System.out.println("1. Edit student");
        System.out.println("2. Back to menu");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();

        //Edit
        switch (choice) {
            case 1:
                System.out.println("Edit new student");

                System.out.print("Name: ");
                String nameEdit = scanner.next();

                System.out.print("Gender: ");
                int genderEdit = scanner.nextInt();

                System.out.print("Dob: ");
                String dobEdit = scanner.next();

                studentDAO.updateStudent(student.getId(), nameEdit, genderEdit, dobEdit);
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("==============================");
    }

    public static void deleteStudent() throws Exception {
        System.out.println("==============================");
        System.out.print("You want to delete student with id: ");
        int number = scanner.nextInt();
        studentDAO.deleteStudent(number);
        System.out.println("==============================");
    }

    public static void main(String[] args) throws Exception {
        int input;

        do {
            menu();

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }

            input = scanner.nextInt();

            switch (input) {
                //Search
                case 0:
                    searchStudent();
                    break;
                //List
                case 1:
                    listStudent();
                    break;
                //Add
                case 2:
                    addStudent();
                    break;
                //Show
                case 3:
                    showStudent();
                    break;
                //Delete
                case 4:
                    deleteStudent();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while (input != 5);
    }
}
