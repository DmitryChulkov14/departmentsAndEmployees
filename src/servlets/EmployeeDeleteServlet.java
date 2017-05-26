package servlets;

import impl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        try (Connection connection = ds.getConnection();
             Statement st = connection.createStatement()){
            st.executeUpdate("DELETE FROM employees WHERE id = " + employee.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/EmployeesServlet").forward(req, resp);

    }
}
