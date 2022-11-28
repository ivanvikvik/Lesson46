package by.itstep.vikvik.controller;

import by.itstep.vikvik.model.dao.GroupDAO;
import by.itstep.vikvik.model.dao.StudentDAO;
import by.itstep.vikvik.model.entity.Group;
import by.itstep.vikvik.model.entity.Student;
import by.itstep.vikvik.model.logic.Manager;

import java.util.List;
import java.util.ResourceBundle;


public class Main {
    public static void main(String[] args) {



        GroupDAO groupDAO = new GroupDAO();
        Group sgroup = new Group("Super Java");
        groupDAO.addGroup(sgroup);

//        StudentDAO studentDAO = new StudentDAO();
//        List<Student> list = studentDAO.getAllStudents();
//        Student student = studentDAO.getStudent(1);
//        System.out.println(student);

//        Group group = new Group(list);
//        System.out.println(group);

//        ResourceBundle bundle = ResourceBundle.getBundle("database");
//        System.out.println(bundle.getString("key"));
//        System.out.println(bundle.getString("name"));

//        Group group = new Group("Java3021");
//        group.add(new Student("Alex", 20, 7.0));
//        group.add(new Student("Alex", 20, 7.5));
//        group.add(new Student("Alex", 20, 8.0));
//        group.add(new Student("Alex", 20, 7.5));
//
//        double total = Manager.calculateAvgMark(group);
//
//        System.out.println("Result: " + total);

    }
}
