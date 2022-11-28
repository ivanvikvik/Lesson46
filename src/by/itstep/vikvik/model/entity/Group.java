package by.itstep.vikvik.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> list;

    public Group() {
        list = new ArrayList<>();
    }

    public Group(String name) {
        this();
        this.name = name;
    }

    public Group(List<Student> list) {
        this.list = list;
    }

    public Group(String name, List<Student> list) {
        this(list);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int size() {
        return list.size();
    }

    public void add(Student student) {
        list.add(student);
    }

    public Student get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of students:");

        for (Student student : list) {
            builder.append("\n").append(student);
        }

        return builder.toString();
    }
}
