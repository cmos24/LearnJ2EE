<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Insert title here</title>
</head>
<body>

你好JSP
<br>

<%-- 因为指令<%@include 会导致两个jsp合并成为同一个java文件，所以就不存在传参的问题，在发出hello.jsp 里定义的变量，直接可以在footer.jsp中访问。

而动作<jsp:include />其实是对footer.jsp进行了一次独立的访问，那么就有传参的需要。

如本例：
1. 在hello.jsp中使用动作<jsp:include，并通过<jsp:param 带上参数
 
<jsp:include page="footer.jsp">
	<jsp:param  name="year" value="2017" />
</jsp:include>
 


2. 在footer.jsp中，使用request.getParameter("year")取出year --%>

<%@include file="footer.jsp" %>
<!-- footer.jsp的内容会被插入到 hello.jsp 转译 成的hello_jsp.java中，最后只会生成一个hello_jsp.java文件 -->



<jsp:include page="footer.jsp">
	<jsp:param name="year" value="2017"/>
</jsp:include>
<!-- footer.jsp的内容不会被插入到 hello.jsp 转译 成的hello_jsp.java中，还会有一个footer_jsp.java独立存在。 hello_jsp.java 会在服务端访问footer_.jsp.java,然后把返回的结果，嵌入到响应中。 -->
<%-- 当需要进行较为复杂的对象传参时，请使用指令方式include
其实，<jsp:include>方式几乎没有用武之地 --%>

<%=new Date().toLocaleString() %>

</body>
</html>