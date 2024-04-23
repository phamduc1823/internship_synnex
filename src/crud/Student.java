package crud;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private int gender;
    private Date dob;

    public Student(int id, String name, int gender, Date dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String sex = gender == 1 ? "Male" : "Female";
        return "id: " + id + ", name: " + name +", gender: " + sex + ", dob: " + dob;
    }
}
