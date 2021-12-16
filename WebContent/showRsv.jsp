<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約内容一覧</title>
<link href = "showRsv.css" rel = "stylesheet">
</head>
<body>
<div class = "content">
<div class = "header">
<a class = "k" href = "/qualtet/index.jsp">カルテット</a>

<ul class = "menu">
	<li class = "menuli"><a   href="/qualtet/LoginServlet?action=logout">ログアウト</a>&ensp;</li>

	<li class = "menuli"><a  href="/qualtet/ChangeMemberServlet?action=detail">会員情報</a>&ensp;</li>

	<li class = "menuli"><a  href="/qualtet/ShowRsvServlet?action=reserve">予約状況</a>&ensp;</li>

	<li class = "menuli"><a href="/qualtet/searchHotel.jsp?">宿を検索</a>&ensp;</li>

	<li class = "menuli"><a  href="/qualtet/adminLogin.jsp?">管理者ログイン</a></li>
</ul>
<ul class = "login">
	<li class = "loginLi"><a href="/qualtet/login.jsp?">ログイン</a>&ensp;</li>
	<li class = "loginLi"><a id = "entry" href="/qualtet/memberEntry.jsp?">新規会員登録</a></li>
</ul>
</div>



<hr size = 30 color = "skyblue">
	<h1 style="text-align: center;">予約内容一覧</h1>
	<hr>


	<c:forEach items="${rsv}" var="rsv">
				予約番号：${rsv.rsv_no}<br>
				宿泊日：${rsv.date}日<br>
				宿泊日数：${rsv.stay}泊<br>
				ホテル名：${rsv.hotel_name}<br>
				ご利用人数：${rsv.rsv_num}名<br>
				プラン：${rsv.plan_name}<br>
				合計金額：${rsv.sum_price}円<br>
		<form action="/qualtet/CancelRsvServlet" method="post">
			<input type="hidden" name="action" value="cancel">
			<input type="hidden" name="rsv_no" value="${rsv.rsv_no}">
			<h2 style="text-align: center;">
				<input type="submit" value="キャンセルする"class = "btn">
			</h2>
		</form>
		<hr>
	</c:forEach>
	</div>
<footer id = "footer">
<p id = "ftext">会社情報</p>
<p class = "ftext2">東京都台東区東上野1-2-11</p>
<p class = "ftext2">000-000-0000</p>
<p class = "ftext2">aaaaaa@ggg.com</p>
<p class = "ftext3">&copy; qualtet Co. Ltd. 2021</p>
</footer>
</body>
</html>