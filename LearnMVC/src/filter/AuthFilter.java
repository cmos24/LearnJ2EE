package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;//ServletRequestû�л��Session�ķ���
		HttpServletResponse response=(HttpServletResponse)res;
		
		
		
		//�����ж��Ƿ��Ƿ��ʵ�login.html��loginHero����Ϊ������ҳ������ڻ�û�е�½֮ǰ����Ҫ���ʵ�
		String uri=request.getRequestURI();
		if(uri.endsWith("login.html")||uri.endsWith("login")){
			chain.doFilter(request, response);
			return;
		}
		//������ʵ���Դ����css����js��β�ģ���ô�Ͳ���Ҫ�ж��Ƿ��¼
        if (uri.endsWith(".css") || uri.endsWith(".js")) {
            chain.doFilter(request, response);
            return;         
        }
		
		
		//��Session�л�ȡuserName�����û�У��ͱ�ʾ������½������ת����½ҳ�档
		String userName=(String)request.getSession().getAttribute("userName");
		if(null==userName){
			response.sendRedirect("login.html");
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
