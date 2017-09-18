<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 进行条件判断，大大简化了 JSTL的 c:if 和 c:choose 代码

如例，一行代码就能其他其他好几行代码的效果
 
${killNumber ge 10? "超神":"还没超神" }
 


例子中讲的是大于等于，除此之外的其他用法如下：
eq相等 ne、neq不相等，
gt大于， lt小于
gt大于， lt小于
gte、ge大于等于 
lte、le 小于等于 
not非 mod求模 
is [not] div by是否能被某数整除 
is [not] even是否为偶数 
is [not] odd是否为奇 --%>

<%
request.setAttribute("killNumber","10");
%>

c:if 的用法运行结果：
<c:if test="${killNumber>=10}">
超神
</c:if>
<c:if test="${killNumber<10}">
还没超神
</c:if>
<br>

c:choose的用法，运行结果：

<c:choose>
	<c:when test="%{killNumber>=10">
		超神
	</c:when>
	<c:otherwise>
		还没超神
	</c:otherwise>	
</c:choose>
<br>

EL表达式eq的用法，运行结果：

${killNumber ge 10? "超神":"还没超神"}