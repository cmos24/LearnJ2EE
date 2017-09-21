package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.User;
import dao.UserDAO;
 
public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDAO().getUser(name, password);//如果用户密码不匹配就没有返回值，user等于null，界面根据这个判断有没有成功登录
        //System.out.println(user.getName()+"-------"+user.getPassword());
        if (null != user) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/JSPShoppingTrolley/listProduct");
        } else
            response.sendRedirect("/JSPShoppingTrolley/login.jsp");
 
    }
}