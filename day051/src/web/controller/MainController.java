package web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ControllerFrame;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/main"})
public class MainController implements ControllerFrame {
	private Logger user_log = Logger.getLogger("user"); 
	
	CustServiceImpl custService;
	
	
    public MainController() {
        super();
        custService = new CustServiceImpl();
    }
    public MainController(CustServiceImpl custService) {
        this.custService = custService;
    }
    @Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String next = "index.jsp";
		String cmd = request.getParameter("cmd");
		
		if(cmd != null){
			next = build(request, cmd);
		}
		
		RequestDispatcher rd = 
		request.getRequestDispatcher(next);
		rd.forward(request, response);		
	}



	private String build(HttpServletRequest request,
			String cmd){
		String next = "index.jsp";
		if(cmd.equals("register")){
			request.setAttribute("center", "register");
		}else if(cmd.equals("map")) {
			request.setAttribute("center", "map/map");
		}else if(cmd.equals("chart")) {
			request.setAttribute("center", "chart/chart");
		}else if(cmd.equals("login")){
			request.setAttribute("center", "login");
		}else if(cmd.equals("loginimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			Cust cust = null;
			try {
				cust = custService.get(id);

				if((cust.getPwd().trim()).equals(pwd.trim())) {
					user_log.debug(cust.getId());
					HttpSession session = request.getSession();
					session.setAttribute("logincust", cust);
				}else {
					throw new Exception();
				}
			} catch (Exception e) {
				request.setAttribute("center", "loginerror");
			}
			
			
		}else if(cmd.equals("logout")) {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
			}
		}
		return next;
	}
	
}
