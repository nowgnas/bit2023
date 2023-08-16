package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.cust.CustServiceImpl;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/js"})
public class JsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustServiceImpl service = null;
	

    public JsServlet() {
        super();
        service = new CustServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "index.jsp";
		String cmd = request.getParameter("cmd");

		if(cmd != null){
			build(request, cmd);
		}

		RequestDispatcher rd = 
				request.getRequestDispatcher(next);
				rd.forward(request, response);
	}
	private void build(HttpServletRequest request,
			String cmd){
		if(cmd.equals("js1")){
			request.setAttribute("center", "js/js1");
		}else if(cmd.equals("js2")){
			request.setAttribute("center", "js/js2");
		}
		
	}


}
