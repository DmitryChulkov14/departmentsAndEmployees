package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clickedButton = req.getParameter("button");
        callNeededServlet(req, resp, clickedButton);
    }

    abstract void callNeededServlet(HttpServletRequest req, HttpServletResponse resp, String clickedButton) throws ServletException, IOException;
}

