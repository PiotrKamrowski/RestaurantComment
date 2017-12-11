package restaurantcomment.service;

import restaurantcomment.place.Place;
import restaurantcomment.user.User;
import restaurantcomment.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReportServlet extends HttpServlet {


    private EntityManagerProvider emp = new EntityManagerProvider();
    private ReportDAO reportDAO = new ReportDAO(emp);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        Place place = (Place) session.getAttribute("detail");


        Long idPlace = place.getId();

        String text = String.valueOf(req.getParameter("text"));

        String userNick = String.valueOf(session.getAttribute("user_nick"));

        UserDAO userDAO = new UserDAO(emp);
        User user = userDAO.userByNick(userNick);

        Report report = new Report();

        report.setReporting(text);
        report.setReported_by(user.getUserId());
        report.setReported_place(idPlace);

        reportDAO.inputReport(report);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/secured/report-success.jsp");
        requestDispatcher.forward(req, resp);
    }
}
