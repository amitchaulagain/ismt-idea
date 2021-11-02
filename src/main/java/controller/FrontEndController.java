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
@WebServlet(urlPatterns = {"/hero", "/product", "/order"})
public class FrontEndController extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    private static final long serialVersionUID = 1L;

    //no-argument constructor
    public FrontEndController() {

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        RequestDispatcher view = null;

        if (path.equals("/hero")) {
            List<User> users = userDAO.findAll();
            request.setAttribute("usersList", users);
            view = request.getRequestDispatcher("admin/users.jsp");
            view.forward(request, response);
        }


        view.forward(request, response);
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