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

	/*OnlineNumberListener ʵ�ֽӿ�HttpSessionListener 

	������һ��session��ʱ�򣬾Ͱ�����+1�����ҷ���application�
	 
	ServletContext application = e.getSession().getServletContext();
	 

	���������jsp���application

	ע: ��һ�δ�application��ȡ���ݵ�ʱ���ǿյģ�Ҫ����Ϊ0��

	������һ��session��ʱ�򣬰��������-1*/
	
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
         ServletContext application=e.getSession().getServletContext();//���������jsp���application
         
         Integer online_number=(Integer)application.getAttribute("online_number");
         
         if(null==online_number){
        	 online_number=0;//��һ�δ�application��ȡ���ݵ�ʱ��ʱ�յģ�Ҫ����Ϊ0
        	 online_number++;
        	 application.setAttribute("online_number", online_number);
        	 
        	 System.out.println("����һλ�����û�");
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
        	 System.out.println("һλ�û�������");
         }
    }
	
}
