import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void init(ServletConfig cnofig) {
		System.out.println("init of Hello Servlet");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			/*设置不使用缓存  提问
			使用缓存可以加快页面的加载，降低服务端的负担。但是也可能看到过时的信息，可以通过如下手段通知浏览器不要使用缓存

			 
			response.setDateHeader("Expires",0 );
			response.setHeader("Cache-Controll","no-cache");
			response.setHeader("pragma","no-cache");*/
			
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Controll", "no-cache");
			response.setHeader("pragma", "no-cache");			
			
			/*获取头信息
			request.getHeader() 获取浏览器传递过来的头信息。 
			比如getHeader("user-agent") 可以获取浏览器的基本资料，这样就能判断是firefox、IE、chrome、或者是safari浏览器
			request.getHeaderNames() 获取浏览器所有的头信息名称，根据头信息名称就能遍历出所有的头信息

			在本例，修改HelloServlet,使其获取头信息
			访问HelloServlet获取如下头信息:
			host: 主机地址
			user-agent: 浏览器基本资料
			accept: 表示浏览器接受的数据类型
			accept-language: 表示浏览器接受的语言
			accept-encoding: 表示浏览器接受的压缩方式，是压缩方式，并非编码
			connection: 是否保持连接
			cache-control: 缓存时限*/
			
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String header = headerNames.nextElement();
				String value = request.getHeader(header);
				System.out.printf("%s\t%s%n", header, value);
			}

			response.getWriter().println("<h1>Hello Servlet!</h1>");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date n = new Date();
			String time = sdf.format(n);
			// response.getWriter().println(new Date().toLocaleString());
			response.getWriter().println(time);
			
			
			/*设置响应格式
			 
			response.setContentType("text/html");
			 


			"text/html" 是即格式 ，在request获取头信息 中对应的request.getHeader("accept"). 
			"text/html" 是存在的，表示浏览器可以识别这种格式，如果换一个其他的格式， 比如 "text/lol" ，浏览器不能识别，那么打开此servlet就会弹出一个下载的对话框。

			这样的手段也就常常用于实现下载功能*/
			response.setContentType("text/lol");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
