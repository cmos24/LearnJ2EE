<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<!-- requestContext与服务端跳转  提问
	requestContext指的是一次请求
	如果发生了服务端跳转，从setContext.jsp跳转到getContext.jsp，这其实，还是一次请求。 所以在getContext.jsp中，可以取到在requestContext中设置的值
	
	这也是一种页面间传递数据的方式 -->

	<%
		application.setAttribute("name","gareen");
		request.setAttribute("name", "teemo");
		request.getRequestDispatcher("getContext.jsp").forward(request,response); //服务端跳转才能获得请求数据
	%>
	

</body>
</html>