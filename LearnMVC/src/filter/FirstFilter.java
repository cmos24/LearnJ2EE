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
		//过滤器应该不仅用于web应用，HttpServletRequest继承自ServletRequest接口，HttpServletRequest增加了与http有关的一些方法
		//doFilter()方法中的req参数的类型是ServletRequest，需要转换为HttpServletRequest类型方便调用某些方法
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String ip=request.getRemoteAddr();//获取来路用户的ip地址
		String url=request.getRequestURL().toString();//获取用户访问的页面地址
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date d=new Date();
		String date=sdf.format(d);
		
		System.out.printf("%s %s 访问了 %s%n",ip,date,url);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("First Filter init");
	}

}
