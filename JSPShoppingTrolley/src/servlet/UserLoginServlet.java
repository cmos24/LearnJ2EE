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
        User user = new UserDAO().getUser(name, password);//����û����벻ƥ���û�з���ֵ��user����null�������������ж���û�гɹ���¼
        //System.out.println(user.getName()+"-------"+user.getPassword());
        if (null != user) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/JSPShoppingTrolley/listProduct");
        } else
            response.sendRedirect("/JSPShoppingTrolley/login.jsp");
 
    }
}