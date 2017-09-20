package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionListener implements HttpSessionListener {
 
    @Override
    public void sessionCreated(HttpSessionEvent e) {
 
        System.out.println("监听到 session 创建, sessionid 是： " + e.getSession().getId());
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
 
        System.out.println("监听到 session 销毁, sessionid 是： " + e.getSession().getId());
    }
}
