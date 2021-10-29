package dao;

import config.JDBCUtils;
import entity.Category;
import entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {


    public List<Category> findAll() {
        List<Category> categorys = new ArrayList<>();
        String QUERY = "select * from category ";

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
                String name = rs.getString("name");
                String description = rs.getString("description");
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                category.setDescription(description);
                categorys.add(category);
            }

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return categorys;
    }

    public Category findById(int categoryId) {
        Category category = null;

        final String QUERY = "select * from category where id =?";

        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1, categoryId);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                // rs.next();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                category=new Category(id,name,description);

            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return category;
    }

    public void delete(int id) {
        String QUERY = "delete from category where id=? ";
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, id);
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

            // Step 4: Process the ResultSet object.
         /*  while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
           }*/
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }

    public void create(Category category) {


        final String INSERT_USERS_SQL = "INSERT INTO category" +
                "  (id, name, description) VALUES " +
                " (?, ?, ?);";
        try (Connection connection = JDBCUtils.getConnection();


             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(2, category.getDescription());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }


    // first argument id - represents id to be updated
    //second argument category- category fields data to be updated

    public void update(int id, Category category) {
        // Step 1: Establishing a Connection
        String UPDATE_USERS_SQL = "update category set id=? , name=? , description=? where id=?;";
        try (Connection connection = JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.setInt(4, id);







            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}


