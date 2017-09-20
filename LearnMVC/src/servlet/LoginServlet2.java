package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.logInf;
import net.sf.json.JSONObject;

//@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*String name=request.getParameter("name");
		String password=request.getParameter("password");*/	
		
		String data=request.getParameter("data");
		System.out.println("服务端接收到的数据是：" +data);
		
		JSONObject json=JSONObject.fromObject(data);
		System.out.println("转换为JSON对象之后是："+ json);
		
		logInf li=(logInf)JSONObject.toBean(json,logInf.class);
				
		String name=li.name;
		String password=li.password;
		
		response.getWriter().print("666");
		
//		System.out.println("获得的参数："+name+password);
		/*if("admin".equals(name)&"123".equals(password)){			
			w.write("success");
		}else{
			w.write("fail");
		}*/
	}

}
