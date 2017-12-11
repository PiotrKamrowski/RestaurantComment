package restaurantcomment.user;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(emp);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nick = String.valueOf(session.getAttribute("user_nick"));

        userDAO.deleteUserByNick(nick);

        session.invalidate();

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);

    }
}
