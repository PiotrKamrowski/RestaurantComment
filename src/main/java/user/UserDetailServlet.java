package user;

import place.Place;
import restaurantcomment.services.EntityManagerProvider;
import review.Review;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserDetailServlet extends HttpServlet {

    private EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    private UserDAO userDAO = new UserDAO(entityManagerProvider);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




       Long id = Long.valueOf(req.getParameter("id"));

        HttpSession session = req.getSession();

        User user = userDAO.getUserById(id);
List<Review> listo = user.getReviewsAdded();


        session.setAttribute("listr",user.getReviewsAdded());
        session.setAttribute("user_detail",user);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/User_detail.jsp");
        requestDispatcher.forward(req, resp);
    }
}


