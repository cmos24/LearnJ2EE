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
		int start = 0;
		int count = 5;

		try {
			start = Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}

		int next = start + count;
		int pre = start - count;

		int total = new HeroDAO().getTotal();
		int last;
		// 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		if (0 == total % count) {
			last = total - count;
			// 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
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