package controller;


import dao.UserDAO;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This servlet program is used to print "Hello World" on
 * client browser using annotations.
 */
@WebServlet(urlPatterns = {"/admin", "/users"})
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public AdminController() {

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        RequestDispatcher view = null;

        if (path.equals("/admin")) {

            view = request.getRequestDispatcher("admin/success.jsp");

        }

        if (path.equals("/users")) {

            UserDAO userDAO = new UserDAO();
            List<User> users = userDAO.findAll();
            request.setAttribute("usersList", users);
            view = request.getRequestDispatcher("admin/users.jsp");

        }

        view.forward(request, response);
    }

//    private List<User> runthis() {
//        List<User> students = new ArrayList<>();
//        // using try-with-resources to avoid closing resources (boiler plate code)
//
//        // Step 1: Establishing a Connection
//        try (Connection connection = JDBCUtils.getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement("select * from student");) {
//            // preparedStatement.setInt(1, 1);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String firstName = rs.getString(2);
//                String lastName = rs.getString("last_name");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                User user = new User();
//                user.setId(id);
//                user.setEmail(email);
//                user.setPhone(phone);
//                students.add(user);
//            }
//
//        } catch (SQLException e) {
//            JDBCUtils.printSQLException(e);
//        }
//        return students;
//        // Step 4: try-with-resource statement will auto close the connection.
//    }


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