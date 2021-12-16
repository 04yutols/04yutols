<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿名一覧</title>
</head>
<body style="text-align:center;">

<h2>宿名一覧</h2>

<c:forEach items="${hotel_name}" var="hotel">
<table border="1">
		<tr><td>${hotel.hotel_name}</td><td><a href = "/qualtet/ChangeHotelServlet?action=update&hotel_no=${hotel.hotel_no}">更新</a>
		</td><td><a href = "/qualtet/DeleteHotelServlet?action=delete&hotel_no=${hotel.hotel_no}">削除</a></tr>
</table>
</c:forEach>

</body>
</html>