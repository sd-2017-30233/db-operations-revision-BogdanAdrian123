package app;

/**
 * Created by BOGDAN on 13.03.2017.
 */
public class Course {


        private int id_course;
        private String name;
        private String teacher;
        private int study_year;

        public Course(int id_course, String name, String teacher, int study_year) {
            this.id_course = id_course;
            this.name = name;
            this.teacher = teacher;
            this.study_year = study_year;
        }

        public int getId_course() {
            return id_course;
        }

        public void setId_course(int id_course) {
            this.id_course = id_course;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public int getStudy_year() {
            return study_year;
        }

        public void setStudy_year(int study_year) {
            this.study_year = study_year;
        }


        public String toString() {
            return "app.Course [id_course=" + id_course + ", name=" + name + ", teacher=" + teacher + ", study_year="
                    + study_year + "]";
        }

    }


