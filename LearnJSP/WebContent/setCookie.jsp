<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<%
		Cookie c = new Cookie("name", "Gareen");//创建一个cookie，名字是“name”	 值是“Gareen”
		c.setMaxAge(24 * 60 * 60);//表示这个cookie可以保留一天，如果是0，表示浏览器一关闭就销毁
		c.setPath("127.0.0.1");//Path表示服务器的主机名，只有浏览器通过这个主机名访问服务器的时候才会提交到这个cookie到服务端
		response.addCookie(c);//通过response把这个cookie保存在浏览器端
	%>
	
	<a href="getCookie.jsp">获取cookie的页面</a>

</body>
</html>