package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EnrollDAO {

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

    public void enrollStudent() {
        Scanner sc = new Scanner(System.in);
        int idstudent = sc.nextInt();
        int idcourse = sc.nextInt();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into enrollment  values ( " + idstudent + "," + idcourse + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }

    }

    public void unenrollStudent(){
        Scanner sc = new Scanner(System.in);
        int idstudent = sc.nextInt();
        int idcourse = sc.nextInt();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("delete from enrollment where student_id=" + idstudent +" and course_id=" +idcourse );
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

}
