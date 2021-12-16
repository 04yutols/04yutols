<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "hotelRsv.css" rel = "stylesheet">
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



<h1 style="text-align:center;color:skyblue;">ご希望のプラン、人数、日にちを入力してください</h1><br>

<hr color = "skyblue">
<div class = "form">

<form action="/qualtet/RsvServlet"method="post">
<h2 style="text-align:center;">プラン:<select name = "plan">
<option value = "1">素泊まりプラン</option>
<option value = "2">朝食付きプラン</option>
<option value = "3">ディナービュッフェ＋朝食付きプラン</option>
<option value = "4">女子会プラン</option>
<option value = "5">スィートルームプラン</option>
<option value = "6">バースデープラン</option>


</select>
</h2><br>

<h2 style="text-align:center;">人数:<select name = "people">
<option value = "1">1</option><option value = "2">2</option><option value = "3">3</option>
<option value = "4">4</option><option value = "5">5</option></select>人</h2><br>
<h2 style="text-align:center;">日付:<input type="date" name="date"></h2><br>

<h2 style="text-align:center;">宿泊日数<select name = "stay">
<option value = "1">1</option>
<option value = "2">2</option>
<option value = "3">3</option>
<option value = "4">4</option>
<option value = "5">5</option>
<option value = "6">6</option>
</select>
泊
</h2><br>
<input type="hidden" name="action" value="confirm">
<input type="submit" value="確認画面へ" class = "btn">

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