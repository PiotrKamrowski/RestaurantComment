package place;

import restaurantcomment.services.EntityManagerProvider;
import review.Review;
import review.ReviewDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DetailPlaceServlet extends HttpServlet {

    EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    PlaceDAO placeDAO = new PlaceDAO(entityManagerProvider);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Long id = Long.valueOf(req.getParameter("theButton"));

        Place place = placeDAO.findByid(id);

        HttpSession session = req.getSession();

        session.setAttribute("detail",place);


        ReviewDAO reviewDAO = new ReviewDAO(entityManagerProvider);

        List<Review> list = place.getReviewList();

        session.setAttribute("listReview",list);

        String sumTimeToGo = "";
        String sumMarkToGo = "";

        if(!list.isEmpty()) {

            int countDelivery = 0;
            int sumTime = 0;
            int sumMark = 0;

            for (Review review : list) {

                String bufforMark = String.valueOf(review.getOveral_mark()).substring(4, 5);


                sumMark = sumMark + Integer.valueOf(bufforMark);


                if (review.getDelivery()) {
                    countDelivery++;

                    sumTime = sumTime + Integer.valueOf(review.getDelivery_time());
                }

            }


            sumMark = sumMark / list.size();
            sumTime = sumTime / countDelivery;


            sumMarkToGo = "STAR" + String.valueOf(sumMark);
            sumTimeToGo = String.valueOf(sumTime);
        }

        session.setAttribute("sumTime",sumTimeToGo);
        session.setAttribute("sumMark",sumMarkToGo);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/detailPlace.jsp");
        requestDispatcher.forward(req, resp);


    }
}
