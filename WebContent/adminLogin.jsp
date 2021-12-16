<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href = "login.css" rel = "stylesheet">
</head>
<body>
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

<h1 style="text-align:center;color:skyblue">Login</h1>
<hr color ="skyblue">
<div class = "center">
<div class = "loginform">
<form action="/qualtet/LoginAdmnServlet"method="post">
<p class = "mtext">ID</p><input type="text" name="id"style="text-align:center;"><br>
<p class = "mtext">パスワード(半角英数字)</p><input type="password" name="pass"style="text-align:center;"><br>
<input type="hidden" name="action" value="login">
<h2 style="text-align:center;"><input type="submit" value="ログイン" class = "btn"></h2>
</form>
</div>
</div>

</body>
</html>