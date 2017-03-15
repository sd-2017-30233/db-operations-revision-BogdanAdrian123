package test;

import app.Student;
import app.StudentDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;


public class StudentTests {

    static StudentDAO sdao = new StudentDAO();

    @BeforeClass
    public static void  setUp(){
        sdao.init();
    }

    @AfterClass
    public static void tearDown(){
        sdao.closeConn();
    }

    @Test
    public void testAddStudent(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqldate = null;
        try {
            java.util.Date date = sdf.parse("1992-04-25");
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }

        Student student = new Student(10,"nume",sqldate,"adresa");

        int sizeBefore = sdao.getAllStudents().size();

        sdao.addStudent(student);

        int sizeAfter = sdao.getAllStudents().size();

        assertEquals("insert failed!",sizeBefore+1,sizeAfter);

    }

    @Test
    public void testDeleteStudent(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqldate = null;
        try {
            java.util.Date date = sdf.parse("1992-04-25");
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }

        Student student = new Student(2,"nume",sqldate,"adresa");

        int sizeBefore = sdao.getAllStudents().size();

        sdao.deleteStudent(3);

        int sizeAfter = sdao.getAllStudents().size();

        assertEquals("delete failed!",sizeBefore-1,sizeAfter);
    }



}
