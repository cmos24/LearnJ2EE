<%-- 示例 1 : 取值  提问
不同版本的tomcat是否默认开启对EL表达式的支持，是不一定的。

所以为了保证EL表达式能够正常使用，需要在<%@page 标签里加上isELIgnored="false"

使用EL表达式，非常简单

比如使用JSTL输出要写成 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="bean.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<c:set var="name" value="${'gareen'}" scope="request" />
  
通过标签获取name: <c:out value="${name}" /> <br>
 
通过 EL 获取name: ${name}

<!-- 示例 2 : 作用域优先级 
EL表达式可以从pageContext,request,session,application四个作用域中取到值，如果4个作用域都有name属性怎么办？ 

EL会按照从小到大的优先级顺序获取 
pageContext>request>session>application -->

<br>

<c:set var="name" value="${'gareen-pageContext'}" scope="page"/>
<c:set var="name" value="${'gareen-request'}" scope="request"/>
<c:set var="name" value="${'gareen-session'}" scope="session"/>
<c:set var="name" value="${'gareen-application'}" scope="application"/>

四个作用域都有name，优先取出来的是：${name}

<%-- 示例 4 : 获取JavaBean的属性
获取JavaBean的属性，只需要通过.符号操作就可以了。

像这样 ${hero.name} --%>

<br>
<%
	Hero hero=new Hero();
	hero.setName("盖伦");
	hero.setHp(616);
	
	request.setAttribute("hero",hero);	
%>

Hero名字：${hero.name}<br>
Hero血量：${hero.hp}