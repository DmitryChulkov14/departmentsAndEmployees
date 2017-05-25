package servlets;

import impl.Constants;
import impl.Department;
import impl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/EmployeeEditServlet")
public class EmployeeEditServlet extends AbstractServlet {

    private Employee employee = new Employee();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEmployeeFields(req);
        session = req.getSession();
        session.setAttribute("employee", employee);
        String clickedButton = req.getParameter("button");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office","jurinson", "admin");
             Statement st = connection.createStatement()){
            doAddOrEdit(clickedButton, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/EmployeesServlet").forward(req, resp);
    }

    private void setEmployeeFields(HttpServletRequest req) {
        employee.setId(Integer.parseInt(req.getParameter("id")));
        employee.setDepartment_id(Integer.parseInt(req.getParameter("department_id")));
        employee.setName(req.getParameter("name"));
        employee.setEmail(req.getParameter("email"));
        employee.setSalary(Integer.parseInt(req.getParameter("salary")));
        employee.setDate(Date.valueOf(req.getParameter("date")));
    }

    private void doAddOrEdit(String clickedButton, Statement st) throws SQLException {
        if (clickedButton.equals(Constants.ADD)) {
            Department department = (Department) session.getAttribute("department");
            st.executeUpdate("INSERT INTO employees (department_id, name, email, salary, date) " +
                    "VALUES ('" + department.getId() + "', '" + employee.getName() + "', '" + employee.getEmail() + "', '" + employee.getSalary() + "', '" + employee.getDate() + "')");
        }
        if (clickedButton.equals(Constants.EDIT)) {
            st.executeUpdate("UPDATE employees " +
                    "SET (name, email, salary, date) = ('" + employee.getName() + "', '" + employee.getEmail() + "', '" + employee.getSalary() + "', '" + employee.getDate() + "') " +
                    "WHERE id = " + employee.getId());
        }
    }
}
