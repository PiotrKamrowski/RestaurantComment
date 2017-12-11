package restaurantcomment.user;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url;


        String nick = String.valueOf(req.getParameter("nick"));

        if (userDAO.noUser(nick)) {

            url = "/index.jsp";

            User user = new User();


            String yyyy = req.getParameter("yyyy");
            String mm = req.getParameter("mm");
            String dd = req.getParameter("dd");

            String birth = yyyy + "-" + mm + "-" + dd;

            String password = req.getParameter("password");
            String encryptedPassword = userDAO.encrypt(password);


            user.setName(String.valueOf(req.getParameter("name")));
            user.setLastname(String.valueOf(req.getParameter("last_name")));
            user.setNick(nick);
            String genderS = req.getParameter("gender");
            user.setBirth(birth);
            user.setCity(String.valueOf(req.getParameter("city")));
            user.setPassword(encryptedPassword);
            Gender gender = Gender.MALE;

            if (genderS.equals("FEMALE")) {
                gender = Gender.FEMALE;
            }

            user.setGender(gender);


            if (userDAO.isValuesNotNull(user)) {

                userDAO.pushUser(user);
            } else {
                url = "/add_user_error.jsp";

            }
        } else {

            url = "/add_user_error_name.jsp";

        }


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);

    }
}

