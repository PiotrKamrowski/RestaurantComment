package restaurantcomment.place;

import restaurantcomment.service.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VIewPlacesSpecyficServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private PlaceDAO placeDAO = new PlaceDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String type = String.valueOf(req.getParameter("type"));

        String city = String.valueOf(req.getParameter("city"));

        List<Place> resultList;

        if (type.equals("")) {

            resultList = placeDAO.getListPlacesByCity(city);

        } else if (city.equals("")) {

            resultList = placeDAO.getListPlacesByType(type);

        } else if (city.equals("") && type.equals("")) {

            resultList = placeDAO.getListPlaces();
        } else {

            resultList = placeDAO.getListPlacesByCityType(type, city);

        }


        HttpSession session = req.getSession();
        session.setAttribute("listParam", resultList);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/list_places_param.jsp");
        requestDispatcher.forward(req, resp);

    }
}
