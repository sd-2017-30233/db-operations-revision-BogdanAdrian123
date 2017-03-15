package app;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BOGDAN on 14.03.2017.d init
 */
public class StudentDAO {

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

public List<Student> getAllStudents(){

    List<Student> students = new ArrayList<>();

    try{

        Statement stmt = conn.createStatement();
        String sql =("select * from student;");
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            int student_id=rs.getInt("student_id");
            String name=rs.getString("name");
            String birth_date=rs.getString("birth_date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqldate = null;
            try {
                java.util.Date date = sdf.parse(birth_date);
                sqldate = new java.sql.Date(date.getTime());
            } catch (Exception e) {
            }

            String address=rs.getString("address");

            students.add(new Student(student_id,name,sqldate,address));

        }

    }catch(Exception e) {
        e.printStackTrace();
    }


    return  students;

}

//--------------------adaugare student----------------------
    public void addStudent(Student student) {
try{
    Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into student (student_id,name,birth_date,address) values ( "+student.getId_student()+",'"+student.getName()+"','"+student.getBirth_date()+"','"+student.getAddress()+"');");
    }catch(Exception e) {
        e.printStackTrace();
                }
       /* if (conn != null) {
            try {
                if (!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }*/

    }
//-----------------------------------------------------------

    //------------stergere student---------------------------
    public void deleteStudent(int id) {
        //Scanner sc = new Scanner(System.in);
       // int aid = sc.nextInt();
        try{

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from enrollment where student_id="+id);
            stmt.executeUpdate("delete from student  where student_id="+id);
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
    //-------------------------------------------------------

    //-------------update student--------------------------
    public void updateStudent(String nume,int id) {
        try{

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("update student set name='"+nume+ "' where student_id="+id);
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
    public void readStudent(int id) {
        try{

            Statement stmt = conn.createStatement();
            String sql =("select * from student where student_id="+id);
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int student_id=rs.getInt("student_id");
                String name=rs.getString("name");
                String birth_date=rs.getString("birth_date");
                String address=rs.getString("address");

                System.out.print(student_id+" "+name+" "+birth_date+" "+address);

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


   public Student createStudent() {
    Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String data = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String address=sc.nextLine();
        java.sql.Date sqldate = null;
        try {
            java.util.Date date = sdf.parse(data);
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }
        return new Student(id,name,sqldate,address);

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
