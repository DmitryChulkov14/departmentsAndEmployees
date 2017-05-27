package servlets;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public abstract class AbstractServlet extends HttpServlet{

    HttpSession session;
    InitialContext initContext;
    DataSource ds = null;
    String clickedButton;

    @Override
    public void init() throws ServletException {
        initConnection();
    }

    void initConnection() {
        try {
            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/dbconnect");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    void setResponseParams(HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
    }
}
