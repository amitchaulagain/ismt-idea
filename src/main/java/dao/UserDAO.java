package dao;

import config.JDBCUtils;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        final String QUERY = "select * from user";
        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();


            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String a = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean isActive = rs.getBoolean("is-active");

               // User user = new User(id, a, email, phone, username, password, isActive);
                //either use above code or the code below
                User user= new User();
                user.setId(id);
                user.setName(a);
                user.setEmail(email);
                user.setPhone(phone);
                user.setUsername(username);
                user.setPassword(password);
                user.setActive(isActive);
                users.add(user);

            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return users;
    }

    public User findById(int id) {
        User user = null;

        final String QUERY = "select * from user where id =?";

        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1,id );
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
                 rs.next();
                int userId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean status = rs.getBoolean("is-active");

                 user= new User(userId,name,email,phone,username,password,status);

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return user;
    }

    public void delete(int id) {
        String QUERY = "delete from user where id=? ";
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, id);
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }

    public void create(User user) {


        final String INSERT_USERS_SQL = "INSERT INTO user" +
                "  (name, email, phone,username, password,`is-active`) VALUES " +
                " (?, ?, ?, ?, ?,?);";
        try (Connection connection = JDBCUtils.getConnection();


             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setBoolean(6, user.isActive());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    public void update(User user) {
        // Step 1: Establishing a Connection
        String UPDATE_USERS_SQL = "update student set phone=? , email=? where id=?;";
        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPhone());

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}


