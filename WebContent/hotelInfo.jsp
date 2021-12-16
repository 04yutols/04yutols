<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hotelInfo</title>
<link href = "hotelInfo.css" rel = "stylesheet">
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

		<p class = "img">
			<img src="/qualtet/img/${hotel.get(0).getPicture_url()}" alt="宿の画像" width="850px">
		</p>

	<h1 style="text-align: center;">${hotel.get(0).getHotel_name()}</h1>

<div class = "detail">
		<div class = "tel">
			<p class = "ptext">電話番号</p>
			<hr>
			${hotel.get(0).getTel()}
			</div>

		<div class = "address">
			<p class = "ptext">住所</p>
			<hr>
			${hotel.get(0).getAddress()}
			</div>

		<div class = "room">
			<p class = "ptext">部屋数</p>
			<hr>
			${hotel.get(0).getRoom()}
			</div>
</div>
<div class ="point">
	<p class = "ptext">アピールポイント</p>
	<hr>
	<br> ${hotel.get(0).getPoint()}
	<br>
</div>
		<div class = "plan">
		<p class = "ptext">プラン一覧</p>
		<hr>
			<p>追加料金のお支払いで以下のプランを選択できます。</p>
			<c:forEach items="${plan}" var="plan">
					<p class = "atext">${plan.plan_name}<br>
					<hr width = "200px">
					${plan.plan_info}<br>
					＋${plan.plan_price}円<br>
					<br><br>
			</c:forEach>

			</div>

<div class = "btn1">
	<a class = "btn" href="/qualtet/RsvServlet?action=jump&hotel_no=${hotel.get(0).getHotel_no()}">予約する</a>
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