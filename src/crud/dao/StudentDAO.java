package crud.dao;

import crud.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public PreparedStatement psTemp(String query) throws Exception {
        conn = new ConnectData().getConnection();
        return conn.prepareStatement(query);
    }

    public List<Student> getAllStudent(String search) throws Exception {
        search = search == null ? "" : search;
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM student WHERE name LIKE ? ORDER BY id DESC LIMIT 5";

        try {
            ps = this.psTemp(query);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4)));
            }
        } finally {
            conn.close();
        }

        return list;
    }

    public void addStudent(String name, int gender, String dob) throws Exception {
        String query = "insert into student (name, gender, dob) values(?,?,?)";

        try {
            ps = this.psTemp(query);
            ps.setString(1, name);
            ps.setInt(2, gender);
            ps.setString(3, dob);
            ps.executeUpdate();
            System.out.println("Student add successfully");
            conn.close();
        }finally {
            conn.close();
        }
    }

    public Student getStudentById(int id) throws Exception {
        String query = "select * from student where id = ?";

        try {
            ps = this.psTemp(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4));
                return student;
            }
        }finally {
            conn.close();
        }

        return null;
    }

    public void updateStudent(int id, String name, int gender, String dob) throws Exception {
        String query = "update student set name = ?, gender = ?, dob = ? where id = ?";

        try {
            ps = this.psTemp(query);
            ps.setString(1, name);
            ps.setInt(2, gender);
            ps.setString(3, dob);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Student update successfully");
        }finally {
            conn.close();
        }
    }

    public void deleteStudent(int id) throws Exception {
        String query = "delete from student where id = ?";

        try {
            ps = this.psTemp(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted successfully");
        }finally {
            conn.close();
        }
    }
}
