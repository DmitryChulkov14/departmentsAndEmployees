package servlets;

import impl.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/DepartmentDeleteServlet")
public class DepartmentDeleteServlet extends AbstractServlet {

    private Department department = new Department();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        department.setId(Integer.parseInt(req.getParameter("curDepartment_id")));

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/office","jurinson", "admin");
             Statement st = connection.createStatement()){
            st.executeUpdate("DELETE FROM departments WHERE id = " + department.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/DepartmentsServlet").forward(req, resp);
    }
}
