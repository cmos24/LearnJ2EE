package filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
//@WebFilter("/FirstFilter")
public class FirstFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FirstFilter() {
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
		//������Ӧ�ò�������webӦ�ã�HttpServletRequest�̳���ServletRequest�ӿڣ�HttpServletRequest��������http�йص�һЩ����
		//doFilter()�����е�req������������ServletRequest����Ҫת��ΪHttpServletRequest���ͷ������ĳЩ����
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String ip=request.getRemoteAddr();//��ȡ��·�û���ip��ַ
		String url=request.getRequestURL().toString();//��ȡ�û����ʵ�ҳ���ַ
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d=new Date();
		String date=sdf.format(d);
		
		System.out.printf("%s %s ������ %s%n",ip,date,url);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("First Filter init");
	}

}
