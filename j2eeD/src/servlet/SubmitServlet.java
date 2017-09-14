package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import bean.Hero1;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SubmitServlet
 */
//@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data=request.getParameter("data");
		
		System.out.println("服务端收到的数据是： "+data);
		
		JSONObject json=JSONObject.fromObject(data);
		
		System.out.println("转换为JSON对象之后是： "+json);
		
		Hero1 hero=(Hero1)JSONObject.toBean(json,Hero1.class);
		System.out.println("转换为Hero对象之后是："+hero);
	}

}
