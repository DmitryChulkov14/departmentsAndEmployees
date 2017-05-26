package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractActionServlet extends AbstractServlet {

    String clickedButton;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.session = req.getSession();
        clickedButton = req.getParameter("button");
        callNeededServlet(req, resp);
    }

    abstract void callNeededServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
