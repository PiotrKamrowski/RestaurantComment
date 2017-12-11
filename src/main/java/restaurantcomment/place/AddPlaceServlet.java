package restaurantcomment.place;


import restaurantcomment.service.EntityManagerProvider;
import restaurantcomment.user.User;
import restaurantcomment.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddPlaceServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private PlaceDAO placeDAO = new PlaceDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Place place = new Place();

        String url = "/secured/place_exist_error.jsp";

        String name = String.valueOf(req.getParameter("name"));
        String city = String.valueOf(req.getParameter("city"));
        String street = String.valueOf(req.getParameter("street"));
        String restaurantUrl = String.valueOf(req.getParameter("www"));
        place.setNumber(String.valueOf(req.getParameter("number")));

        if(restaurantUrl.equals("")){
            restaurantUrl = "nie podano";
        }

        String ident = name + ";" + city + ";" + street;

        place.setIdent(ident);
        if (placeDAO.noPlace(ident)) {


            HttpSession session = req.getSession();

            UserDAO userDAO = new UserDAO(emp);

            User user = userDAO.userByNick(String.valueOf(session.getAttribute("user_nick")));
            place.setCreated_by(user.getUserId());
            place.setName(name);
            place.setCity(city);
            place.setStreet(street);
            place.setWww(restaurantUrl);

            place.setType(Type.valueOf(req.getParameter("type")));
            place.setDelivery(Boolean.valueOf(req.getParameter("delivery")));

            if (placeDAO.isValuesNotNull(place)) {

                placeDAO.pushPlace(place);

                url = "/secured/main.jsp";
            }
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }

}