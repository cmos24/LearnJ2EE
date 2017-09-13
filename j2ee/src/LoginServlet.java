import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/*
	 * service() LoginServlet继承了HttpServlet,同时也继承了一个方法
	 * 
	 * service(HttpServletRequest , HttpServletResponse )
	 * 
	 * 
	 * 
	 * 实际上，在执行doGet()或者doPost()之前，都会先执行service()
	 * 
	 * 由service()方法进行判断，到底该调用doGet()还是doPost()
	 * 
	 * 可以发现，service(), doGet(), doPost() 三种方式的参数列表都是一样的。
	 * 
	 * 所以，有时候也会直接重写service()方法，在其中提供相应的服务，就不用区分到底是get还是post了。
	 * 
	 * 比如把前面的登录的LoginServlet，改为提供service方法，也可以达到相同的效果
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
		System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
		System.out.println("请求行中的参数部分: " + request.getQueryString());
		System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
		System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
		System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
		System.out.println("服务器的IP地址: " + request.getLocalAddr());
		System.out.println("服务器的主机名: " + request.getLocalName());
		System.out.println("得到客户机请求方式: " + request.getMethod());
		/*
		 * 在servlet进行解码和编码
		 * 
		 * byte[] bytes= name.getBytes("ISO-8859-1"); name = new
		 * String(bytes,"UTF-8");
		 * 
		 * 
		 * 先根据ISO-8859-1解码，然后用UTF-8编码 这样就可以得到正确的中文参数了
		 * 
		 * 这样需要对每一个提交的数据都进行编码和解码处理，如果觉得麻烦，也可以使用一句话代替：
		 */
		request.setCharacterEncoding("UTF-8");// 并且把这句话放在request.getParameter()之前

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		System.out.println("name=" + name);
		System.out.println("password=" + password);

		String html = null;
		/*
		 * 比较的时候把常量字符串"admin" "123"放前面，因为用户可能没有输入账号密码就提交， servlet会获取到null。
		 * 这样就规避了空指针异常的问题。
		 */
		if ("admin".equals(name) && "123".equals(password)) {
			request.getRequestDispatcher("success.html").forward(request, response);
			// html="<div style='color:green'>登录成功</div>";
		} else {
			response.sendRedirect("fail.html");
			// html="<div style='color:red'>登录失败</div>";
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(html);
	}
}
