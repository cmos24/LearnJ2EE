package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String userName=(String)request.getSession().getAttribute("userName");
		if(null==userName){
			response.sendRedirect("login.html");
			return;//���userNameΪ�գ���ִ���������ת
		}
		
		int start = 0;
		int count = 5;

		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// �������û�д�����startʱ
		}

		int next = start + count;
		int pre = start - count;

		int total = new HeroDAO().getTotal();
		int last;
		// ����������50�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����45
		if (0 == total % count) {
			last = total - count;
			// ����������51�����ܹ���5�����ģ���ô���һҳ�Ŀ�ʼ����50
		} else {
			last = total - total % count;
		}

		pre = pre < 0 ? 0 : pre;
		next = next > last ? last : next;

		List<Hero> heros = new HeroDAO().list(start, count);

		request.setAttribute("next", next);
		request.setAttribute("pre", pre);
		request.setAttribute("last", last);

		request.setAttribute("heros", heros);

		request.getRequestDispatcher("listHero.jsp").forward(request, response);

	}
}