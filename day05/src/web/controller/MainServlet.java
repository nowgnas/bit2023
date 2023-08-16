package web.controller;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/main"})
public class MainServlet extends HttpServlet {
    private Logger work_log = Logger.getLogger("work");

    private static final long serialVersionUID = 1L;
    CustServiceImpl custService;

    public MainServlet() {
        this.custService = new CustServiceImpl();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String next = "index.jsp";
        String cmd = request.getParameter("cmd");

        if (cmd != null) {
            build(request, cmd);
        }

        RequestDispatcher rd =
                request.getRequestDispatcher(next);
        rd.forward(request, response);
    }


    private void build(HttpServletRequest request, String cmd) {
        if (cmd.equals("register")) {
            request.setAttribute("center", "register");
        } else if (cmd.equals("login")) {
            request.setAttribute("center", "login");
        } else if (cmd.equals("loginimpl")) {
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            Cust cust = null;
            try {
                cust = custService.get(id);
                if ((cust.getPwd()).equals(pwd)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("logincust", cust);
                }
            } catch (Exception e) {
                request.setAttribute("center", "login error");
            }
        } else if (cmd.equals("logout")) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
        }
    }
}
