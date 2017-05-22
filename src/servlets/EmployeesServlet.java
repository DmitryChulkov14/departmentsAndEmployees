package servlets;

import impl.Constants;
import impl.Departament;
import impl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends AbstractServlet {

    private Set<Employee> employees = new LinkedHashSet<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseParams(resp);
        String curDepartmentId = req.getParameter("curDepartment_id");
        String curDepartmentName = req.getParameter("curDepartment_name");
        String curButton = req.getParameter("button");
        /*System.out.println(curDepartmentId + curButton);*/
        /*String nameOfButton = req.getParameter("submit");
        if (nameOfButton.equals(Constants.EMPLOYEES_LIST)){
            resp.sendRedirect("listOfEmployees.jsp");
        }*/

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office", "jurinson", "admin");
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM employees WHERE department_id = " + curDepartmentId)) {
            employees.clear();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getInt("salary"), rs.getDate("date")));
            }

            req.setAttribute("employeesList", employees);
            req.setAttribute("department_name", curDepartmentName);
            req.getRequestDispatcher("listOfEmployees.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
