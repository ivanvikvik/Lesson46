package by.itstep.vikvik.model.dao;

import by.itstep.vikvik.model.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentDAO extends AbstractDAO {
    public static final String ADD_STUDENT = "INSERT INTO students VALUES(default, ?, ?, ?, ?)";
    public static final String UPDATE_STUDENT = "UPDATE students SET name = ?, age = ?, mark = ? WHERE id_student = ?";
    public static final String DELETE_STUDENT = "DELETE FROM students WHERE id_student = ?";

    public static final String SELECT_ALL_STUDENTS = "SELECT name, age, mark FROM students";
    public static final String SELECT_STUDENT = "SELECT * FROM students WHERE id_student = ?";

    private Connection connection;

    public StudentDAO() {
        connection = getConnection();
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_STUDENTS);

            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setMark(rs.getDouble("mark"));
                list.add(student);
            }
        } catch (
                SQLException exception) {
            System.out.println(exception);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println(exception);
                }
            }
        }

        return list;
    }

    public Student getStudent(int id) {
        Student student = null;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SELECT_STUDENT);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            rs.next();
            student = new Student();
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setMark(rs.getDouble("mark"));

        } catch (SQLException exception) {
            System.out.println(exception);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    System.out.println(exception);
                }
            }
        }

        return student;
    }

    protected void finalize()  {
        releaseConnection(connection);
    }
}
