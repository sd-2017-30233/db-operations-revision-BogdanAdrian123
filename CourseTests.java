package test;

import app.CourseDAO;
import app.Course;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class CourseTests {

    static CourseDAO cdao = new CourseDAO();

    @BeforeClass
    public static void  setUp(){
        cdao.init();
    }

    @AfterClass
    public static void tearDown(){
        cdao.closeConn();
    }

    @Test
    public void testAddCourse(){

        Course course = new Course(2,"nume","teacher",3);

        int sizeBefore = cdao.getAllCourses().size();

        cdao.addCourse(course);

        int sizeAfter = cdao.getAllCourses().size();

        assertEquals("insert failed!",sizeBefore+1,sizeAfter);

    }

    @Test
    public void testDeleteCourse(){
        Course course = new Course(8,"nume","teacher",3);

        int sizeBefore = cdao.getAllCourses().size();

        cdao.deleteCourse(2);

        int sizeAfter = cdao.getAllCourses().size();

        assertEquals("delete failed!",sizeBefore-1,sizeAfter);

    }

}
