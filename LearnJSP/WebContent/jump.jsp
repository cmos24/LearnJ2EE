<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		response.sendRedirect("hello.jsp");
	%>

<%-- 服务端跳转
与Servlet的服务端跳转一样，也可以使用
 
request.getRequestDispatcher("hello.jsp").forward(request, response);
 


或者使用动作，简化代码
 
<jsp:forward page="hello.jsp"/> --%>

</body>
</html>