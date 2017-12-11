package restaurantcomment.user;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(emp);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<User> listOfUsers = userDAO.getAll();

        session.setAttribute("listOfUsers", listOfUsers);


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/list_users.jsp");
        requestDispatcher.forward(req, resp);
    }

}
