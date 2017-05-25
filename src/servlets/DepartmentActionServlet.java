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
    void callNeededServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (clickedButton != null){
            if (clickedButton.equals(Constants.ADD)){
                department.clearName();
                setAttributes();
                req.getRequestDispatcher("/departmentEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.EDIT)){
                setDepartmentFields(req);
                setAttributes();
                req.getRequestDispatcher("/departmentEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.DELETE)){
                req.getRequestDispatcher("/DepartmentDeleteServlet").forward(req, resp);
            }
            if (clickedButton.equals(Constants.EMPLOYEES_LIST)){
                setDepartmentFields(req);
                setAttributes();
                req.getRequestDispatcher("/EmployeesServlet").forward(req, resp);
            }
        }
    }

    private void setDepartmentFields(HttpServletRequest req) {
        department.setId(Integer.parseInt(req.getParameter("curDepartment_id")));
        department.setName(req.getParameter("curDepartment_name"));
    }

    private void setAttributes() {
        if (!clickedButton.equals(Constants.EMPLOYEES_LIST)){
            super.session.setAttribute("departmentClickedButton", clickedButton);
        }
        super.session.setAttribute("department", department);
    }
}
