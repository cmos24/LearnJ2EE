package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		System.out.println("hello123123");
		
		if("admin".equals(name)&"123".equals(password)){
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("listHero");//¿Í»§¶ËÌø×ª
		}else{
			request.getSession().removeAttribute("userName");
			response.sendRedirect("login.html");
		}
	}
}
