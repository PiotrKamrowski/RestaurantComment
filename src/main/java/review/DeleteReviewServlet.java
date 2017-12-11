package review;

import restaurantcomment.services.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteReviewServlet extends HttpServlet {

    private EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    private ReviewDAO reviewDAO = new ReviewDAO(entityManagerProvider);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Long id = Long.valueOf(req.getParameter("review_id"));

       Review review = reviewDAO.GetReview(id);

       reviewDAO.deleteReview(id);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/listplaces.jsp");
        requestDispatcher.forward(req, resp);

    }
}
