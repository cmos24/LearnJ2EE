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
		
		response.sendRedirect("listHero");	//��Ե�ǰҳ���λ������ת�����統ǰ��http://127.0.0.1:8080/j2eeD/listHeroҳ�棬
											//�ͻ���ת�������ҳ�棬���д��"j2eeD/listHero�ͻ���ת��http://127.0.0.1:8080/j2eeD/j2eeD/listHero"
											//���д��"/listHero"�ͻ���ת��http://127.0.0.1:8080/listHero
	}
}
