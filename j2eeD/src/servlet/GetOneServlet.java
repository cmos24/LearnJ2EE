package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero1;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetOneServlet
 */
//@WebServlet("/GetOneServlet")
public class GetOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*1. 创建一个Hero对象
		2. 创建一个JSONObject 对象
		3. 把Hero对象转换为JSONObject 对象，并放在上一个JSONObject对象上，key是"hero"
		4. 设置编码方式为UTF-8
		5. 通过response返回*/
//		System.out.println("收到信息");
		
		Hero1 hero=new Hero1();
		hero.setName("盖伦");
		hero.setHp(500);
		
		JSONObject json=new JSONObject();
		
		json.put("hero",JSONObject.fromObject(hero));
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
