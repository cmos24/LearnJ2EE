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
        if(null==u){//���session�л�ȡ����user����û�е�¼����ת����½ҳ��
            response.sendRedirect("/JSPShoppingTrolley/login.jsp");
            return;
        }
         
        Order o = new Order();
        o.setUser(u);
 
        new OrderDAO().insert(o);
 
        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");//��ô����session�е�OrderItems
        for (OrderItem oi : ois) {
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
         
        ois.clear();
         
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("���������ɹ�");
 
    }
}