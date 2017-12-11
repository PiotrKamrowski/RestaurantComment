package restaurantcomment.review;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteReviewServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private ReviewDAO reviewDAO = new ReviewDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("review_id"));

        reviewDAO.deleteReview(id);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/list_places.jsp");
        requestDispatcher.forward(req, resp);

    }
}
