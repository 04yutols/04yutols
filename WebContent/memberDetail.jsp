<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="la.bean.MemberBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報表示</title>
<link href = "memberDetail.css" rel = "stylesheet">
</head>
<body style=text-align:center;>
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
<h2>会員情報</h2>
<div class = "detail">
名前：${memberDetail.get(0).getName()}<br><br>
住所：${memberDetail.get(0).getAddress()}<br><br>
電話番号：${memberDetail.get(0).getTel()}<br><br>
メールアドレス：${memberDetail.get(0).getEmail()}<br><br>
生年月日：${memberDetail.get(0).getBirthday()}<br><br>
パスワード：${memberDetail.get(0).getPassword()}<br><br>
</div>
<div class = "form"></div>
<a href = "/qualtet/ChangeMemberServlet?action=change" class = "btn1">編集</a>
<a href = "/qualtet/ChangeMemberServlet?action=delete" class = "btn">退会</a>
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