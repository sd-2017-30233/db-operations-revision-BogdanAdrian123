package app; /**
 * Created by BOGDAN on 13.03.2017.
 */


import java.util.List;

public class JDBC {

    public static void main(String[]args){



StudentDAO sdao=new StudentDAO();
CourseDAO cdao= new CourseDAO();
EnrollDAO edao=new EnrollDAO();


    // ------------student--------------------------
         //sdao.init();
        // sdao.addStudent(sdao.createStudent());
        // sdao.deleteStudent(1);
        // sdao.updateStudent("mariusica",7);
        // sdao.readStudent();
        /*List<Student> list = sdao.getAllStudents();
        for(Student s: list){
            System.out.println(s);
        }*/



    // -------------course---------------------------
   // cdao.init();
         // cdao.addCourse(cdao.createCourse());
         // cdao.deleteCourse(8);
         // cdao.updateCourse("matematice nespeciale",4);
         // cdao.readCourse(2);


    //-------------enroll-----------------------------
    //edao.init();
   // edao.enrollStudent();
    //edao.unenrollStudent();
    }
}
