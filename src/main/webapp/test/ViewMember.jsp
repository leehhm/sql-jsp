<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

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
<title>학생 추가문</title>
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
	<form action="${contextPath}/boad/addstudent" method="post">
		<table align="center">
			<h1>학생 추가</h1>
			<hr>
			<tr>
				<td width="110"><p>아이디 :</p></td>
				<td width="50"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="110"><p>이름 :</p></td>
				<td width="50"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td width="110"><p>대학교 :</p></td>
				<td width="50"><input type="text" name="univ"></td>
			</tr>
			<tr>
				<td width="110"><p>생일 :</p></td>
				<td width="50"><input type="date" name="birth"></td>
			</tr>
			<tr>
				<td width="110"><p>이메일 :</p></td>
				<td width="50"><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="110"><p>&nbsp;</p></td>
				<td width="50"><input value="회원가입" type="submit" /> <input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>