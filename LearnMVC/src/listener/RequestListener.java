package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
//@WebListener
public class RequestListener implements ServletRequestAttributeListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  {//当本次请求结束的时候触发
    	System.out.println("销毁了一个request");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         System.out.println("request移除属性");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  {//当新创建了一个Request的时候触发，只要访问了服务端的资源，就会创建一个Request，无论是jsp,servlet还是html
    	System.out.println("创建了一个request");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent e)  {//当有新增属性时触发
         System.out.println("request增加属性");
         System.out.println("属性是："+e.getName());
         System.out.println("值是："+e.getValue());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  {
    	System.out.println("request替换属性");
    }
	
}
