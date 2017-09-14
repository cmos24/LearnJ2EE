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
		/*1. ����һ��Hero����
		2. ����һ��JSONObject ����
		3. ��Hero����ת��ΪJSONObject ���󣬲�������һ��JSONObject�����ϣ�key��"hero"
		4. ���ñ��뷽ʽΪUTF-8
		5. ͨ��response����*/
//		System.out.println("�յ���Ϣ");
		
		Hero1 hero=new Hero1();
		hero.setName("����");
		hero.setHp(500);
		
		JSONObject json=new JSONObject();
		
		json.put("hero",JSONObject.fromObject(hero));
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
