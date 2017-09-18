package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;

public class HeroDeleteServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		new HeroDAO().delete(id);
		
		response.sendRedirect("listHero");	//相对当前页面的位置做跳转，比如当前在http://127.0.0.1:8080/j2eeD/listHero页面，
											//就会跳转到本身的页面，如果写成"j2eeD/listHero就会跳转到http://127.0.0.1:8080/j2eeD/j2eeD/listHero"
											//如果写成"/listHero"就会跳转到http://127.0.0.1:8080/listHero
	}
}
