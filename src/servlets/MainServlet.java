package servlets;

import impl.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);

        /*String nameOfDepartments = req.getParameter("name");
        String nameOfButton = req.getParameter("submit");
        if (nameOfButton.equals(Constants.EMPLOYEES_LIST)){
            resp.sendRedirect("listOfEmployees.jsp");
        }*/
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office","jurinson", "admin");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT employees.name AS employee_name, departments.name AS department_name " +
                     "FROM employees, departments " +
                     "WHERE employees.department_id = 1 AND employees.department_id = departments.id");
             PrintWriter printWriter = resp.getWriter()) {
            while (rs.next()) {
                printWriter.print(rs.getString("employee_name") + " из " + rs.getString("department_name") + "<br/>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setResponseParams(HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
    }
}
