import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Select PreparedStatement JDBC Example
 *
 * @author Ramesh Fadatare
 */
public class SelectAllStatementExample {
    private static final String QUERY = "select * from student ";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();


            List<Student> students = new ArrayList<>();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Student student = new Student();
                student.setId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setPhone(phone);
                students.add(student);
            }

            for (Student st:students) {
                System.out.println(st.id);

            }



        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
}
