package advance.threads;

import crud.Student;
import crud.dao.StudentDAO;

import java.util.List;
import java.util.Scanner;

public class StudentThread {
    public static void main(String[] args) {
        AddStudentThread addStudent = new AddStudentThread();
        ListStudent listStudent = new ListStudent();

        addStudent.start();

        try {
            addStudent.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listStudent.start();
    }
}

class ListStudent extends Thread {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    public void run() {
        try {
            synchronized (studentDAO){
                List<Student> list = studentDAO.getAllStudent(null);
                for (Student student : list) {
                    System.out.println(student);
                }
                studentDAO.wait();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class AddStudentThread extends Thread {
    Scanner sc = new Scanner(System.in);
    private StudentDAO studentDAO = new StudentDAO();

    public void run() {
        try {
            synchronized(studentDAO) {
                System.out.println("Student add:");
                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Gender: ");
                int gender = sc.nextInt();

                System.out.print("Dob: ");
                String dob = sc.next();

                studentDAO.addStudent(name, gender, dob);
                studentDAO.notify();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}