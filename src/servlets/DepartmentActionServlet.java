package servlets;

import impl.Constants;
import impl.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DepartmentActionServlet")
public class DepartmentActionServlet extends AbstractActionServlet {

    Department department = new Department();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    void callNeededServlet(HttpServletRequest req, HttpServletResponse resp, String clickedButton) throws ServletException, IOException {
        if (clickedButton != null){
            if (clickedButton.equals(Constants.ADD)){
                department.clearName();
                setAttributes(req, clickedButton);
                req.getRequestDispatcher("/departmentEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.EDIT)){
                department.setId(Integer.parseInt(req.getParameter("curDepartment_id")));
                department.setName(req.getParameter("curDepartment_name"));
                setAttributes(req, clickedButton);
                req.getRequestDispatcher("/departmentEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.DELETE)){
                req.getRequestDispatcher("/DepartmentDeleteServlet").forward(req, resp);
            }
            if (clickedButton.equals(Constants.EMPLOYEES_LIST)){
                req.getRequestDispatcher("/EmployeesServlet").forward(req, resp);
            }
        }
    }

    private void setAttributes(HttpServletRequest req, String clickedButton) {
        req.setAttribute("clickedButton", clickedButton);
        req.setAttribute("department", department);
    }
}
