package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineNumberListener
 *
 */
//@WebListener
public class OnlineNumberListener implements HttpSessionListener {

	/*OnlineNumberListener 实现接口HttpSessionListener 

	当创建一个session的时候，就把数字+1，并且放在application里。
	 
	ServletContext application = e.getSession().getServletContext();
	 

	就是这就是jsp里的application

	注: 第一次从application里取数据的时候，是空的，要设置为0。

	当销毁一个session的时候，把这个数字-1*/
	
    /**
     * Default constructor. 
     */
    public OnlineNumberListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent e)  { 
         ServletContext application=e.getSession().getServletContext();//就是这就是jsp里的application
         
         Integer online_number=(Integer)application.getAttribute("online_number");
         
         if(null==online_number){
        	 online_number=0;//第一次从application里取数据的时候时空的，要设置为0
        	 online_number++;
        	 application.setAttribute("online_number", online_number);
        	 
        	 System.out.println("新增一位在线用户");
         }
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent e)  { 
         ServletContext application=e.getSession().getServletContext();
         
         Integer online_number=(Integer)application.getAttribute("online_number");
         
         if(null==online_number){
        	 online_number=0;
         }else{
        	 online_number--;
        	 application.setAttribute("online_number", online_number);
        	 System.out.println("一位用户离线了");
         }
    }
	
}
