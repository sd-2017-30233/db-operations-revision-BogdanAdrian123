package app;

/**
 * Created by BOGDAN on 13.03.2017.
 */

public class Enroll {

    private int id_student;
    private int id_course;

    public Enroll(int id_student, int id_course) {
        this.id_student = id_student;
        this.id_course = id_course;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String toString() {
        return "app.Enroll [id_student=" + id_student + ", id_course=" + id_course + "]";
    }




}
