<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="hp" value="${10}" scope="request"/>

<c:if test="${hp<5 }">
	<p>要挂了</p>
</c:if>

<c:if test="${!(hp<5) }">
	<p>还能抢救一下</p>
</c:if>

<% 
	pageContext.setAttribute("weapon",null);
	pageContext.setAttribute("lastwords","");
	pageContext.setAttribute("items",new ArrayList());
%>

<c:if test="${empty weapon }">
	<p>没有装备武器</p>
</c:if>
<c:if test="${empty lastwords }">
	<p>没有遗言</p>
</c:if>
<c:if test="${empty items }">
	<p>物品栏为空</p>
</c:if>