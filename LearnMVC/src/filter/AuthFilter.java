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
		HttpServletRequest request=(HttpServletRequest)req;//ServletRequest没有获得Session的方法
		HttpServletResponse response=(HttpServletResponse)res;
		
		
		
		//首先判断是否是访问的login.html和loginHero，因为这两个页面就是在还没有登陆之前就需要访问的
		String uri=request.getRequestURI();
		if(uri.endsWith("login.html")||uri.endsWith("login")){
			chain.doFilter(request, response);
			return;
		}
		//如果访问的资源是以css或者js结尾的，那么就不需要判断是否登录
        if (uri.endsWith(".css") || uri.endsWith(".js")) {
            chain.doFilter(request, response);
            return;         
        }
		
		
		//从Session中获取userName，如果没有，就表示不曾登陆过，跳转到登陆页面。
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
