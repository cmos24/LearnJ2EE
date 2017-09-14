package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		
		List<Hero> heros=new HeroDAO().list();
		
		StringBuffer sb=new StringBuffer();
		sb.append("<table align='center' border='1' cellspacing='0'");
		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>Edit</td><td>delete</td></tr>\r\n");
		
		String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>Edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
		
		for(Hero hero:heros){
			String tr=String.format(trFormat, hero.getId(),hero.getName(),hero.getHp(),hero.getDamage(),hero.getId(),hero.getId());
			sb.append(tr);
		}
		
		sb.append("</table>");
		
		response.getWriter().write(sb.toString());
		
	}
}
