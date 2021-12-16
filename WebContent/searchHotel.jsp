<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href = "serchHotel.css" rel = "stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class = "content">
<div class = "header">
<a class = "k">カルテット</a>

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
<h1 style="text-align:center;color:skyblue">宿の検索</h1>
<hr color ="skyblue">

<div class = "serch1">
<div class = "category">
<h2 class ="ptext">カテゴリー検索</h2>
<form action="/qualtet/SerchHotelServlet"method="post">
<select name="categoryNo">
<option value = 1>シティホテル</option>
<option value = 2>リゾートホテル</option>
<option value = 3>ビジネスホテル</option>
<option value = 4>旅館</option>
<option value = 5>民宿</option>
<option value = 6>ペンション</option>
</select>
<input type="hidden" name = "action" value = "serchCategory">
<br>
<br>
<input type="submit" value="検索" class = "btn">
</form>
</div>
<div class = "price">
<h2 class = "ptext">価格帯検索</h2>
<a href="/qualtet/SerchHotelServlet?action=serchPrice&minPrice=4000&maxPrice=7000">4,000円台～6,000円台</a><br>
<a href="/qualtet/SerchHotelServlet?action=serchPrice&minPrice=7000&maxPrice=9000">7,000円台～9,000円台</a><br>
<a href="/qualtet/SerchHotelServlet?action=serchPrice&minPrice=10000&maxPrice=1000000">10,000円以上</a><br>
</div>
</div>
<div class = "key">
<form action="/qualtet/SerchHotelServlet"method="post">
<h2 class = "ptext">キーワード検索</h2><input type="text" name="key">
<br>
<br>
<input type="submit" value="検索" class = "btn">
 <input type="hidden" name="action" value="serchKey">
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