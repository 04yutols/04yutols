<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報更新ページ</title>
<link href = "changeMember.css" rel = "stylesheet">
</head>
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

<h2 class = "h2">会員情報の変更</h2>
<div class = "form">
<p class = "mtext">変更したい情報を入力して下さい。</p>



<br><br>
<form action="/qualtet/ChangeMemberServlet" method="post">
名前：<input type="text" name="user_name" value = "${memberDetail.get(0).getName()}" maxlength='50'>
<br><br>住所：<input type="text" name="address" value = "${memberDetail.get(0).getAddress()}"maxlength='200'>
<br><br>電話番号：<input type="text" name="tel" value = "${memberDetail.get(0).getTel()}"maxlength='20'>
<br><br>メールアドレス：<input type="text" name="email" value = "${memberDetail.get(0).getEmail()}"maxlength='20'>
<br><br>生年月日：<input type="date" name="birthday" value = "${memberDetail.get(0).getBirthday()}">
<br><br>パスワード（半角英数字）：<input type="text" name="password" value = "${memberDetail.get(0).getPassword()}"maxlength='16' >
<br><br>

<input type="submit" value="更新">
<input type="hidden" name="action" value="change_member">
</form>
</div>
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