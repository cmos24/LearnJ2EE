<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	List<String> heros = new ArrayList<String>();
	heros.add("塔姆");
	heros.add("艾克");
	heros.add("巴德");
	heros.add("雷克赛");
	heros.add("卡莉丝塔");
	request.setAttribute("heros", heros);
%>

<table width="200px" align="center" border="1" cellspacing="0">
<tr>
	<td>编号</td>
	<td>英雄</td>
</tr>

<c:forEach items="${heros}" var="hero" varStatus="st">
	<tr>
		<td>${st.count}</td>
		<td>${hero}</td>
	</tr>
</c:forEach>
</table>