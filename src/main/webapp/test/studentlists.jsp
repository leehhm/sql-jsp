<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, test01.*" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 출력창</title>
<style type="text/css">
.cls1 {
	font-size: 40px;
	text-align: center;
}

.cls2 {
	text-align: center;
}
</style>
</head>
<body>
	<table align="center" width="100%" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">아이디</td>
			<td width="7%">학생이름</td>
			<td width="7%">대학교</td>
			<td width="7%">생일</td>
			<td width="7%">이메일</td>
		</tr>
		<c:choose>
			<c:when test="${studentsList == null}">
				<tr align="center">
					<td colspan="5" width="7%"><b>등록된 회원이 없습니다.</b></td>
				</tr>
			</c:when>
			<c:when test="${studentsList != null }">
				<c:forEach var="std" items="${studentsList}">
					<tr align="center">
						<td width="7%">${std.id }</td>
						<td width="7%">${std.username }</td>
						<td width="7%">${std.univ }</td>
						<td width="7%">${std.birth }</td>
					
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<form method="get" action="${contextPath}/boad/newstudent">
		<input type="submit" value="등록" /> 
	</form>
</body>
</html>