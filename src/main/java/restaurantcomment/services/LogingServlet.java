package restaurantcomment.services;

import user.User;
import user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogingServlet extends HttpServlet {
    private EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(entityManagerProvider);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String password = String.valueOf(req.getParameter("password"));

        String nick = String.valueOf(req.getParameter("nick"));
        String url = "/login_page_r.jsp";




        if(!userDAO.noUser(nick)) {

            User user = userDAO.userByNick(nick);

            String passwordUser = user.getPassword();


            passwordUser = userDAO.decrypt(passwordUser);





            if (passwordUser.equals(password)) {

                HttpSession session = req.getSession();

                session.setAttribute("user_nick", nick);

                Cookie cookie = new Cookie("login", nick);
                cookie.setMaxAge(3600);
                resp.addCookie(cookie);

                url = "/secured/main.jsp";

            }
        }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
            requestDispatcher.forward(req, resp);






    }
}
