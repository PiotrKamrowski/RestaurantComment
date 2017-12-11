package place;

import restaurantcomment.services.EntityManagerProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewPlacesServlet extends HttpServlet {

    private EntityManagerProvider emp = new EntityManagerProvider();
    private PlaceDAO placeDAO = new PlaceDAO(emp);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Place> listplaces = placeDAO.getListPlaces();



        HttpSession session = req.getSession();

        session.setAttribute("listPlaces",listplaces);

        req.setAttribute("list",listplaces);


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/listplaces.jsp");
        requestDispatcher.forward(req, resp);


    }
    }

