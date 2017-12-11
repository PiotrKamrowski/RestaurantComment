package restaurantcomment.user;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditUserServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(emp);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nick = String.valueOf(session.getAttribute("user_nick"));

        User user = userDAO.userByNick(nick);
        String yyyy = req.getParameter("yyyy");
        String mm = req.getParameter("mm");
        String dd = req.getParameter("dd");
        String birth = yyyy + "-" + mm + "-" + dd;

        String password = req.getParameter("password");
        String encryptedPassword = userDAO.encrypt(password);

        user.setName(String.valueOf(req.getParameter("name")));
        user.setLastname(String.valueOf(req.getParameter("last_name")));
        user.setBirth(birth);
        user.setCity(String.valueOf(req.getParameter("city")));
        user.setPassword(encryptedPassword);

        userDAO.pushUser(user);

    }

}
