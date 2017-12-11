package place;

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

public class AddPlaceServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private PlaceDAO placeDAO = new PlaceDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Place place = new Place();


        String url = "/secured/main.jsp";

        String name = String.valueOf(req.getParameter("name"));
        String city = String.valueOf(req.getParameter("city"));
        String street = String.valueOf(req.getParameter("street"));
        String www = String.valueOf(req.getParameter("www"));
        place.setNumber(String.valueOf(req.getParameter("number")));

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

            place.setType(Type.valueOf(req.getParameter("type")));
            place.setDelivery(Boolean.valueOf(req.getParameter("delivery")));

            System.out.println(place.getCity() + "/" + place.getName() + "/" + place.getNumber() + "/" + place.getStreet());

            if (placeDAO.isValuesNotNull(place)) {

                placeDAO.pushPlace(place);

                url = "/secured/main.jsp";
            }


        }


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(req, resp);
    }

}