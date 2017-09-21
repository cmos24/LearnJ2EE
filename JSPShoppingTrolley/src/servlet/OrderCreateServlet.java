package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;
 
public class OrderCreateServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        User u = (User) request.getSession().getAttribute("user");
        if(null==u){//如果session中获取不到user就是没有登录，跳转到登陆页面
            response.sendRedirect("/JSPShoppingTrolley/login.jsp");
            return;
        }
         
        Order o = new Order();
        o.setUser(u);
 
        new OrderDAO().insert(o);
 
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");//获得存放在session中的OrderItems
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
         
        ois.clear();
         
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");
 
    }
}