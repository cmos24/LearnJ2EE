<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
    application.setAttribute("test", 1);
    application.setAttribute("test", 2);
    application.removeAttribute("test");
%>