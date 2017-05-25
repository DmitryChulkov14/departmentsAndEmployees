package servlets;

import impl.Department;
import impl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends AbstractServlet {

    private Department department = new Department();
    private Set<Employee> employees = new LinkedHashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);
        session = req.getSession();
        department = (Department) session.getAttribute("department");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office", "jurinson", "admin");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE department_id = " + department.getId() + " ORDER BY id")) {
            employees.clear();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), department.getId(), rs.getString("name"), rs.getString("email"),
                        rs.getInt("salary"), rs.getDate("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("employeesList", employees);
        req.getRequestDispatcher("listOfEmployees.jsp").forward(req, resp);
    }
}
