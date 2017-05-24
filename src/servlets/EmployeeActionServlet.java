package servlets;

import impl.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeActionServlet")
public class EmployeeActionServlet extends AbstractActionServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    void callNeededServlet(HttpServletRequest req, HttpServletResponse resp, String clickedButton) throws ServletException, IOException {
        if (clickedButton != null){
            if (clickedButton.equals(Constants.ADD) || clickedButton.equals(Constants.EDIT)){
                req.getRequestDispatcher("/EmployeeEditServlet").forward(req, resp);
            }
            if (clickedButton.equals(Constants.DELETE)){
                req.getRequestDispatcher("/EmployeeDeleteServlet").forward(req, resp);
            }
        }
    }
}
