<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	request参数：
	<%=request.getAttribute("name")%>
	<br>
	<%
		String appName=(String)application.getAttribute("name");
		response.getWriter().println("全局参数："+appName);
	%>

</body>
</html>