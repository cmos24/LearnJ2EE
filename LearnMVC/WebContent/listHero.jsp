<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,bean.Hero" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<script>
	$(function() {
		$("a").addClass("btn btn-default btn-xs");
	});
</script>

<table style="width: 500px; margin: 44px auto"
	class="table table-striped table-bordered table-hover  table-condensed"
	align='center' border='1' cellspacing='0'>
	<tr>
		<td>id</td>
		<td>name</td>
		<td>hp</td>
		<td>damage</td>
		<td>edit</td>
		<td>delete</td>
	</tr>
	<c:forEach items="${heros}" var="hero" varStatus="st">
		<tr>
			<td>${hero.id}</td>
			<td>${hero.name}</td>
			<td>${hero.hp}</td>
			<td>${hero.damage}</td>
			<td><a href="editHero?id=${hero.id}">编辑</a></td>
			<td><a href="deleteHero?id=${hero.id}">删除</a></td>
		</tr>
	</c:forEach>

</table>

<nav>
	<ul class="pager">

		<li><a href="?start=0">首 页</a></li>
		<li><a href="?start=${pre}">上一页</a></li>
		<li><a href="?start=${next}">下一页</a></li>
		<li><a href="?start=${last}">末 页</a></li>
	</ul>
</nav>