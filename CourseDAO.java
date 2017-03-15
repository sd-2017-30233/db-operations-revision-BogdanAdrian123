package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CourseDAO {

    Connection conn = null;

    public void init(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/tema2ps";
            conn = DriverManager.getConnection(url, "root", "bogdan");
            System.out.println("Successfully connected to the database");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    public List<Course> getAllCourses(){

        List<Course> courses = new ArrayList<>();

        try{

            Statement stmt = conn.createStatement();
            String sql =("select * from course;");
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int course_id=rs.getInt("course_id");
                String name=rs.getString("name");
                String teacher=rs.getString("teacher");
                int study_year=rs.getInt("study_year");
                courses.add(new Course(course_id,name,teacher,study_year));

            }

        }catch(Exception e) {
            e.printStackTrace();
        }

        return  courses;

    }



    //--------------------adaugare curs----------------------
    public void addCourse(Course course) {
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into course (course_id,name,teacher,study_year) values ( "+course.getId_course()+",'"+course.getName()+"','"+course.getTeacher()+"','"+course.getStudy_year()+"');");
        }catch(Exception e) {
            e.printStackTrace();
        }
        /*if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
*/
    }
//-----------------------------------------------------------

    //------------stergere student---------------------------
    public void deleteCourse(int id) {
        //Scanner sc = new Scanner(System.in);
        // int aid = sc.nextInt();
        try{

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from enrollment where course_id="+id);
            stmt.executeUpdate("delete from course where course_id="+id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        /*if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }*/

    }
    //-------------------------------------------------------

    //-------------update student--------------------------
    public void updateCourse(String nume,int id) {
        try{

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update course set name='"+nume+ "' where course_id="+id);
        }catch(Exception e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }

    }
    //-----------------------------------------------------

    //---------read student-------------------------------
    public void readCourse(int id) {
        try{

            Statement stmt = conn.createStatement();
            String sql =("select * from course where course_id="+id);
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int course_id=rs.getInt("course_id");
                String name=rs.getString("name");
                String teacher=rs.getString("teacher");
                int study_year=rs.getInt("study_year");

                System.out.print(course_id+" "+name+" "+teacher+" "+study_year);

            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    //----------------------------------------------------


    public Course createCourse() {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String teacher = sc.nextLine();
        int study_year=sc.nextInt();
        return new Course(id,name,teacher,study_year);

    }

    public void closeConn(){

        if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }

    }
}
