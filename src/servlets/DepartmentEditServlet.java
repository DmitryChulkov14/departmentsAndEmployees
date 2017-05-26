package servlets;

import impl.Constants;
import impl.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/DepartmentEditServlet")
public class DepartmentEditServlet extends AbstractServlet {

    private Department department = new Department();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        department.setId(Integer.parseInt(req.getParameter("curDepartment_id")));
        department.setName(req.getParameter("name"));
        String clickedButton = req.getParameter("button");

        try (Connection connection = ds.getConnection();
             Statement st = connection.createStatement()){
            doAddOrEdit(clickedButton, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/DepartmentsServlet").forward(req, resp);
    }

    private void doAddOrEdit(String clickedButton, Statement st) throws SQLException {
        if (clickedButton.equals(Constants.ADD)) {
            st.executeUpdate("INSERT INTO departments (name) VALUES ('" + department.getName() + "')");
        }
        if (clickedButton.equals(Constants.EDIT)) {
            st.executeUpdate("UPDATE departments SET name = ('" + department.getName() + "') WHERE id = " + department.getId());
        }
    }
}
