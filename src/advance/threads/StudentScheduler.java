package advance.threads;

import crud.Student;
import crud.dao.StudentDAO;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StudentScheduler {
    public static void main(String[] args) {
        UpdateTask updateTask = new UpdateTask();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(updateTask, 0, 3, TimeUnit.SECONDS);
    }
}

class UpdateTask implements Runnable {
    @Override
    public void run() {
        listStudentList();
    }

    private void listStudentList() {
        StudentDAO studentDAO = new StudentDAO();

        List<Student> latestStudents = null;
        try {
            latestStudents = studentDAO.getAllStudent(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Student student : latestStudents) {
            System.out.println(student);
        }
        System.out.println("============================================");
    }
}
