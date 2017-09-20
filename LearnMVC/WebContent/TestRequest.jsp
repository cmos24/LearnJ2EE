<%@ page language="java"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	request.setAttribute("test",1);
	request.setAttribute("test",2);
	request.removeAttribute("test");
%>