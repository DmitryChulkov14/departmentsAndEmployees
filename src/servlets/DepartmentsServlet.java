package servlets;

import impl.Departament;

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

    private Set<Departament> departments = new LinkedHashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office","jurinson", "admin");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM departments")) {
            departments.clear();
            while (rs.next()) {
                departments.add(new Departament(rs.getInt("id"), rs.getString("name")));
            }

            req.setAttribute("depList", departments);
            req.getRequestDispatcher("listOfDepartments.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}