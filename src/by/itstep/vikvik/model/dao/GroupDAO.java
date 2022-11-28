package by.itstep.vikvik.model.dao;

import by.itstep.vikvik.model.entity.Group;
import by.itstep.vikvik.model.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends AbstractDAO {
    public static final String ADD_GROUP = "INSERT INTO studentsdb.groups VALUES(default, ?)";
    public static final String UPDATE_GROUP = "UPDATE groups SET name = ? WHERE id_group = ?";
    public static final String DELETE_GROUP = "DELETE FROM groups WHERE id_group = ?";

    public static final String SELECT_ALL_GROUPS = "SELECT name FROM groups";
    public static final String SELECT_GROUP = "SELECT name FROM groups WHERE id_group = ?";

    private Connection connection;

    public GroupDAO(Connection connection) {
        this.connection = connection;
    }

    public int addGroup(Group group) {
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(ADD_GROUP);

            statement.setString(1, group.getName());

            result = statement.executeUpdate();

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

        return result;
    }

    public int deleteGroup(int id) {
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(DELETE_GROUP);

            statement.setInt(1, id);

            result = statement.executeUpdate();

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

        return result;
    }
}
