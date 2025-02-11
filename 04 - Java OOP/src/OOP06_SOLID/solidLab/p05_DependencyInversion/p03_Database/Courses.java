package OOP06_SOLID.solidLab.p05_DependencyInversion.p03_Database;

import java.security.PublicKey;

public class Courses {

    private Data database;

    public Courses(Data database) {
        this.database = database;
    }

    public void setDatabase(Data database){
        this.database = database;
    }

    public void printAll() {
//        Data database = new Data();
        Iterable<String> courses = database.courseNames();

        //print courses
    }

    public void printIds() {
//        Data database = new Data();
        Iterable<Integer>coursesIds = database.courseIds();

        //print course ids
    }

    public void printById(int id) {
//        Data database = new Data();
        String course = database.getCourseById(id);

        // print course
    }

    public void search(String substring) {
//        Data database = new Data();
        Iterable<String> courses = database.search(substring);

        // print courses
    }
}
