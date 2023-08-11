package web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/cust"})
public class CustServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String next = "cust/main.jsp";
        RequestDispatcher rd =
                request.getRequestDispatcher(next);
        rd.forward(request, response);
    }


}
