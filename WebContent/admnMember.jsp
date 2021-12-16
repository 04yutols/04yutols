<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報一覧ページ</title>
</head>
<body style="text-align:center;">

<h2>会員情報一覧</h2>

<br>
<c:forEach items="${member}" var="member">
<table border="0">
	<tr><td>${member.name}</td><td><a href = "/qualtet/AdmnMemberServlet?action=update&user_id=${member.id}">更新
	</a><a href = "/qualtet/AdmnDeleteMemberServlet?action=confirm&user_id=${member.id}">退会</a></tr>
</table>
</c:forEach>

	<br><br>
	　
</body>
</html>