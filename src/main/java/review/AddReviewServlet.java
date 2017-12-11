package review;

import place.Place;
import restaurantcomment.services.EntityManagerProvider;
import user.User;
import user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;





public class AddReviewServlet extends HttpServlet {

    private EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    private ReviewDAO reviewDAO = new ReviewDAO(entityManagerProvider);



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDAO userDAO = new UserDAO(entityManagerProvider);

        HttpSession session = req.getSession();

        Place place = (Place)session.getAttribute("detail");

        Long placeId = place.getId();

        User user = userDAO.userByNick(String.valueOf(session.getAttribute("user_nick")));


        Long postedBy = user.getUserId();

        Review review = new Review();

        Boolean delivery = Boolean.valueOf(req.getParameter("delivery"));
        String time = String.valueOf(req.getParameter("time"));

        if(!delivery){
            time ="-";
        }


        review.setPosted_by(postedBy);
        review.setPlace_id(placeId);
        review.setDelivery(Boolean.valueOf(req.getParameter("delivery")));
        review.setDelivery_time(time);
        review.setOveral_mark(Mark.valueOf(req.getParameter("mark")));
        review.setReview(String.valueOf(req.getParameter("review")));

        reviewDAO.pushReview(review);

      session.setAttribute("ok",Long.valueOf(placeId));

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/add_review_succes.jsp");
        requestDispatcher.forward(req, resp);


    }
}
