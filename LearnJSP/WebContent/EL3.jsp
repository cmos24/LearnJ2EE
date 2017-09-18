<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<!--
EL表达式还可以做到request.getParameter("name") 这样的形式获取浏览器传递过来的参数
先把jstl.jsp代码改为如例所示，然后访问如下地址
 
http://127.0.0.1/jstl.jsp?name=abc
 

可以观察到获取了参数 name -->
    
${param.name}