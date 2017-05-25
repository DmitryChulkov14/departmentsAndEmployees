package servlets;

import impl.Constants;
import impl.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/EmployeeActionServlet")
public class EmployeeActionServlet extends AbstractActionServlet {

    Employee employee = new Employee();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    void callNeededServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (clickedButton != null){
            if (clickedButton.equals(Constants.ADD)){
                employee.clearAllFields();
                setAttributes();
                req.getRequestDispatcher("/employeeEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.EDIT)){
                setEmployeeFields(req);
                setAttributes();
                req.getRequestDispatcher("/employeeEditor.jsp").forward(req, resp);
            }
            if (clickedButton.equals(Constants.DELETE)){
                setEmployeeFields(req);
                setAttributes();
                req.getRequestDispatcher("/EmployeeDeleteServlet").forward(req, resp);
            }
        }
    }

    private void setEmployeeFields(HttpServletRequest req) {
        employee.setId(Integer.parseInt(req.getParameter("employee_id")));
        employee.setDepartment_id(Integer.parseInt(req.getParameter("employee_department_it")));
        employee.setName(req.getParameter("employee_name"));
        employee.setEmail(req.getParameter("employee_email"));
        employee.setSalary(Integer.parseInt(req.getParameter("employee_salary")));
        employee.setDate(Date.valueOf(req.getParameter("employee_date")));
    }

    private void setAttributes() {
        if (!clickedButton.equals(Constants.DELETE)){
            session.setAttribute("employeeClickedButton", clickedButton);
        }
        session.setAttribute("employee", employee);
    }
}
