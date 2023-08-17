package web.controller;

import app.cust.CustServiceImpl;
import app.dto.Cust;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet({"/rest"})
public class RestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    CustServiceImpl custService = null;

    public RestServlet() {
        super();
        custService = new CustServiceImpl();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        Object result = "";

        if (cmd != null) {
            result = build(request, cmd);
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(result);


    }


    private Object build(HttpServletRequest request,
            String cmd) {
        Object result = null;
        if (cmd.equals("checkid")) {
            result = 0;
            String id = request.getParameter("id");
            Cust cust = null;
            try {
                cust = custService.get(id);
                if (cust != null) {
                    result = 1;
                }
            } catch (Exception e) {
                result = 1;
            }
        } else if (cmd.equals("chart1")) {
            JSONArray ja = new JSONArray();
            JSONObject jo = new JSONObject();
            jo.put("name", "KO");
            JSONArray data = new JSONArray();
            data.put(16.0);
            data.put(17.0);
            data.put(11.0);
            data.put(12.0);
            data.put(18.0);
            data.put(19.0);
            data.put(20.0);
            data.put(33.0);
            data.put(12.0);
            data.put(13.0);
            data.put(12.0);
            data.put(11.0);
            jo.put("data", data);
            ja.put(jo);
            result = ja;
        }
        return result;
    }
}
