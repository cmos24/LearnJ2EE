package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero1;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class GetManyServlet
 */
//@WebServlet("/GetManyServlet")
public class GetManyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetManyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Hero1> heros=new ArrayList<Hero1>();
		
		for(int i=0;i<10;i++){
			Hero1 hero=new Hero1();
			hero.setName("hero"+i);
			hero.setHp(500+i);			
			heros.add(hero);
		}
		String result=JSONSerializer.toJSON(heros).toString();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
