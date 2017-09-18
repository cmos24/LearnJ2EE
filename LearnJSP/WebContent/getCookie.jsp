<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>
 
<%
    Cookie[] cookies = request.getCookies();
    if (null != cookies)
        for (int d = 0; d <= cookies.length - 1; d++) {
            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
        }
%>