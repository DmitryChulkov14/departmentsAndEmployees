package servlets;

import impl.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/DepartmentsServlet")
public class DepartmentsServlet extends AbstractServlet {

    private Set<Department> departments = new LinkedHashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        setResponseParams(resp);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office","jurinson", "admin");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM departments ORDER BY id")) {
            departments.clear();
            while (rs.next()) {
                departments.add(new Department(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("depList", departments);
        req.getRequestDispatcher("/listOfDepartments.jsp").forward(req, resp);
    }
}
