<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberEntry</title>
<link href = "memberEntry.css" rel = "stylesheet">
</head>
<body style="text-align:center;">
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
<h2 class = "h2">新規会員登録ページ</h2><br>
<hr color = "skyblue">
<h3>会員の名前、住所、電話番号、メールアドレス、生年月日、パスワードを入力してください。（全項目入力必須）</h3><br><br>
<div class = "form">
<form action="/qualtet/MemberEntryServlet" method="post">
名前：<input type="text" name="user_name" size="5" maxlength='50'><br><br>
住所：<input type="text" name="address" size="5" maxlength='200'><br><br>
電話番号：<input type="text" name="tel" size="5" maxlength='20'><br><br>
メールアドレス：<input type="text" name="email" size="5" maxlength='50'>@<select name ="domain">
<option value = "gmail.com">gmail.com</option>
<option value = "icloud.com">icloud.com</option>
<option value = "yahoo.co.jp">yahoo.co.jp</option>
<option value = "ezweb.ne.jp">ezweb.ne.jp</option>
<option value = "au.com">au.com</option>
<option value = "docomo.ne.jp">docomo.ne.jp</option>
<option value = "softbank.ne.jp">softbank.ne.jp</option>
</select>
<br><br>
生年月日：<input type="date" name=birthday size="5"><br><br>
パスワード：<input type="text" name="password" size="5" maxlength='16'><br><br>
<input type="submit" value="登録する">
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