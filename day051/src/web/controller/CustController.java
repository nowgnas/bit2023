package web.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import app.frame.ControllerFrame;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/cust"})
public class CustController implements ControllerFrame {
	
	CustServiceImpl service = null;
	

    public CustController() {
        super();
        service = new CustServiceImpl();
    }
    public CustController(CustServiceImpl service) {
        this.service = service;
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
			request.setAttribute("center", "cust/register");
		}else if(cmd.equals("registerimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			try {
				Cust cust = new Cust(id, pwd, name);
				service.register(cust);
				
				next = "cust.bit?cmd=get&id="+id;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("getall")){
			List<Cust> list = null;
			try {
				list = service.get();
				request.setAttribute("clist", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("center", "cust/getall");
		}else if(cmd.equals("get")) {
			String id = request.getParameter("id");
			Cust cust = null;
			try {
				cust = service.get(id);
				request.setAttribute("dcust", cust);
				request.setAttribute("center", "cust/get");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("getall")) {
			List<Cust> list = null;
			try {
				list = service.get();
				request.setAttribute("clist", list);
				request.setAttribute("center", "cust/getall");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("modifyimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			try {
				Cust cust = new Cust(id, pwd, name);
				service.modify(cust);
				
				next = "cust.bit?cmd=get&id="+id;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("removeimpl")) {
			String id = request.getParameter("id");
			try {
				service.remove(id);
				next = "cust.bit?cmd=getall";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return next;
	}
	


}
