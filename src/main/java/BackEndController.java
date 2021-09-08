import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This servlet program is used to print "Hello World" on
 * client browser using annotations.
 */
@WebServlet(urlPatterns = {"/admin"})
public class BackEndController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public BackEndController() {

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        RequestDispatcher view = null;

        if (path.equals("/admin")) {

            List<String> values = new ArrayList<>();
            values.add("one");
            values.add("two");
            values.add("three");


            System.out.println("---here");
            request.setAttribute("institution", "ISMT College");

            request.setAttribute("phoneNumber", "9802332322");
            byte x = 5;


            Animal animal = new Animal();
            animal.setName("Lucifer Cat");
            animal.setColor("black");
            // animal

            request.setAttribute("apple", x);
            request.setAttribute("ball", 12.23);
            request.setAttribute("cat", animal);
            request.setAttribute("dog", values);


            for (String s : values) {
                System.out.println(s);
            }

            List<Student> students = runthis();


            request.setAttribute("ss", students);


            System.out.println("---end");

            String idFromUrl = (String) request.getAttribute("id");
            if (idFromUrl != null) {
                System.out.println(idFromUrl);
            }

            view = request.getRequestDispatcher("admin/success.jsp");

        }

        view.forward(request, response);
    }

    private List<Student> runthis() {
        List<Student> students = new ArrayList<>();
        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from student");) {
            // preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();


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

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return students;
        // Step 4: try-with-resource statement will auto close the connection.
    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/hero")) {
            RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
            view.forward(request, response);

        }
    }
}