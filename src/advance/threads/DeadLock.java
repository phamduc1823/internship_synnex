package advance.threads;

import crud.Student;
import crud.dao.StudentDAO;

import java.util.List;

public class DeadLock {
    private static StudentDAO studentDAO1 = new StudentDAO();
    private static StudentDAO studentDAO2 = new StudentDAO();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (studentDAO1) {
                    try {
                        studentDAO1.addStudent("LP", 2, "1998-02-03");

                        Thread.sleep(100);

                        synchronized (studentDAO2) {
                            System.out.println("Hien thi danh sach");
                            List<Student> students = studentDAO2.getAllStudent(null);

                            for (Student student : students) {
                                System.out.println(student);
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (studentDAO2) {
                    try {
                        List<Student> students = studentDAO2.getAllStudent(null);
                        for (Student student : students) {
                            System.out.println(student);
                        }

                        Thread.sleep(100);

                        synchronized (studentDAO1) {
                            System.out.println("Tao moi du lieu");
                            studentDAO1.addStudent("LP", 2, "1998-02-03");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
