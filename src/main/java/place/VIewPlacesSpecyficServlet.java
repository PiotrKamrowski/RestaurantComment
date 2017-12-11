package place;

import restaurantcomment.services.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VIewPlacesSpecyficServlet extends HttpServlet{

    private EntityManagerProvider emp = new EntityManagerProvider();
    private PlaceDAO placeDAO = new PlaceDAO(emp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String type =String.valueOf(req.getParameter("type"));

        System.out.println(type);

        String city = String.valueOf(req.getParameter("city"));

        System.out.println(city);

        List<Place> resultList = new ArrayList<>();

        if(type.equals("")){

           resultList = placeDAO.getListPlacesbyCity(city);
        }else if(city.equals("")){

            resultList = placeDAO.getListPlacesbyType(type);

        }else if(city.equals("") && type.equals("")){

            resultList = placeDAO.getListPlaces();
        }else{

            resultList = placeDAO.getListPlacesByCityType(type,city);

        }

        System.out.println(resultList.isEmpty());

        for(Place a:resultList) {

            System.out.println("restauracja :"+a);
        }

        HttpSession session = req.getSession();
        session.setAttribute("listParam",resultList);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/listplacesParam.jsp");
        requestDispatcher.forward(req, resp);


    }
}
