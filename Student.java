package app;

/**
 * Created by BOGDAN on 13.03.2017.
 */
public class Student {

        private int id_student;
        private String name;
        private java.sql.Date birth_date;
        private String address;

        public Student(int id_student,String name , java.sql.Date birth_date, String address){
            this.id_student=id_student;
            this.name=name;
            this.birth_date=birth_date;
            this.address=address;

        }

        public int getId_student() {
            return id_student;
        }

        public void setId_student(int id_student) {
            this.id_student = id_student;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public java.sql.Date getBirth_date() {
            return birth_date;
        }

        public void setBirth_date(java.sql.Date birth_date) {
            this.birth_date = birth_date;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "app.Student [id_student=" + id_student + ", name=" + name + ", birth_date=" + birth_date + ", address="
                    + address + "]";
        }



}
