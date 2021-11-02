package controller;


import dao.CategoryDAO;
import dao.UserDAO;
import entity.Category;
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
//TODO :  email too long  --resolved
//TODO :  edit user    --resolved







@WebServlet(urlPatterns = {"/admin", "/users", "/createUser", "/viewUser", "/deleteUser",
        "/editUser","/categories", "/createCategory", "/viewCategory", "/deleteCategory",
        "/editCategory"})
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAO();
    CategoryDAO categoryDAO = new CategoryDAO();



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

            view = request.getRequestDispatcher("admin/admin.jsp");
            view.forward(request, response);

        }
        if (path.equals("/createUser")) {


            view = request.getRequestDispatcher("admin/create-user.jsp");
            view.forward(request, response);

        }

        if (path.equals("/editUser")) {
            String id = request.getParameter("id");

            User user=userDAO.findById(Integer.parseInt(id));

            request.setAttribute("user",user );
            view = request.getRequestDispatcher("admin/edit-user.jsp");
            view.forward(request, response);

        }
        if (path.equals("/viewUser")) {


            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.findById(id);
            request.setAttribute("ourUser", user);
            view = request.getRequestDispatcher("admin/view-user.jsp");
            view.forward(request, response);

        }
        if (path.equals("/deleteUser")) {


            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.delete(id);

            response.sendRedirect("/users");


        }
        if (path.equals("/users")) {

            List<User> users = userDAO.findAll();
            request.setAttribute("usersList", users);
            view = request.getRequestDispatcher("admin/users.jsp");
            view.forward(request, response);

        }

        if (path.equals("/categories")) {

            List<Category> categories = categoryDAO.findAll();
            request.setAttribute("categories", categories);
            view = request.getRequestDispatcher("admin/categories.jsp");
            view.forward(request, response);

        }


        if (path.equals("/createCategory")) {


            view = request.getRequestDispatcher("admin/create-user.jsp");
            view.forward(request, response);

        }

        if (path.equals("/editCategory")) {
            String id = request.getParameter("id");

            User user=userDAO.findById(Integer.parseInt(id));

            request.setAttribute("user",user );
            view = request.getRequestDispatcher("admin/edit-user.jsp");
            view.forward(request, response);

        }
        if (path.equals("/viewCategory")) {


            int id = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.findById(id);
            request.setAttribute("ourUser", user);
            view = request.getRequestDispatcher("admin/view-user.jsp");
            view.forward(request, response);

        }
        if (path.equals("/deleteCategory")) {


            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.delete(id);

            response.sendRedirect("/users");


        }

        if (path.equals("/users")) {

            List<User> users = userDAO.findAll();
            request.setAttribute("usersList", users);
            view = request.getRequestDispatcher("admin/users.jsp");
            view.forward(request, response);
            return;

        }


    }



    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/createUser")) {


            String name = request.getParameter("name");
            String email = request.getParameter("email");

            String phone = request.getParameter("phone");

            String username = request.getParameter("username");

            String password = request.getParameter("password");


            boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));


            User user = new User(name, email, phone, username, password, isActive);


            userDAO.create(user);


            System.out.println("I am here");


            response.sendRedirect("/users");

        }
    }

    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/createUser")) {

            System.out.println("I am here");


            RequestDispatcher view = request.getRequestDispatcher("success.jsp");
            view.forward(request, response);

        }
    }


    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);

        if (request.getServletPath().equals("/editUser")) {


            RequestDispatcher view = request.getRequestDispatcher("success.jsp");
            view.forward(request, response);

        }
    }
}

