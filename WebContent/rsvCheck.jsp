<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "rsvCheck.css" rel = "stylesheet">
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

	<h1 style="text-align: center;">以下の内容で予約します</h1>
	<div class = "table">
	<table border="1">

			<tr><th>名前</th><td>${mbean.name}</td></tr>
			<tr><th>プラン</th><td>${pbean.plan_name}</td></tr>
			<tr><th>住所</th><td>${mbean.address}</td></tr>
			<tr><th>電話</th><td>${mbean.tel}</td></tr>
			<tr><th>日付</th><td>${rbean.date}</td></tr>
			<tr><th>人数</th><td>${rbean.rsv_num}名</td></tr>
			<tr><th>宿泊日数</th><td>${rbean.stay}泊</td></tr>
			<tr><th>合計金額</th><td>${priceSum}円</td></tr>

	</table>
	</div>
	<form action="/qualtet/RsvServlet"method="post">
<input type="hidden" name="action" value="rsvComp">
<h2 style="text-align:center;"><input type="submit" value="予約を確定する" class = "btn"></h2>
</form>
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