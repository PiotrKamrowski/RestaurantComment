package restaurantcomment.services;

import com.sun.org.apache.regexp.internal.RE;
import user.User;
import user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReportServlet extends HttpServlet {


    private EntityManagerProvider entityManagerProvider = new EntityManagerProvider();
    private ReportDAO reportDAO = new ReportDAO(entityManagerProvider);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        Long idPlace = Long.valueOf(req.getParameter("id"));

        String text = String.valueOf(req.getParameter("text"));

        String userNick = String.valueOf(req.getParameter("user_nick"));

        UserDAO userDAO = new UserDAO(entityManagerProvider);
        User user = userDAO.userByNick(userNick);

        Report report = new Report();

        report.setReporting(text);
        report.setRepoted_by(user.getUserId());
        report.setReported_place(idPlace);

        reportDAO.inputReport(report);

    }
}
