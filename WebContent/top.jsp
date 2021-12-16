<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
<link href = "top.css" rel = "stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript">
        $(document).ready(function(){
            $('.slider').bxSlider({
                auto: true,
                pause: 3000,
            });
        });
</script>

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
<div class="slider">
<img src="/qualtet/img/img21.jpeg" width="400px" height="500px" alt="">
<img src="/qualtet/img/img15.jpg" width="400px" height="500px" alt="">
<img src="/qualtet/img/img11.jpeg" width="400px" height="500px" alt="">
<img src="/qualtet/img/img24.jpeg" width="400px" height="500px" alt="">
<img src="/qualtet/img/img26.jpg" width="400px" height="500px" alt="">
<img src="/qualtet/img/img12.jpeg" width="400px" height="500px" alt="">
</div>
<div class = "inn">
	<h3>☆おすすめの宿☆</h3>
	</div>
<div>

	<c:forEach items="${hotel}" var="hotel">
	<table class = "table" >
<tr><th class = "name"> ${hotel.hotel_name}</th></tr>
<tr><td><img src="/qualtet/img/${hotel.picture_url}" alt="宿の画像" width=200px height=100px ></td></tr>
<tr><td><a class = "price">${hotel.price}円~&ensp;&ensp;</a><a class = "detail" href="/qualtet/SerchHotelServlet?action=detail&no=${hotel.hotel_no}">詳細を表示</a></td></tr>
</table>
</c:forEach>

</div>
</div>
<div class = "push"></div>
<footer id = "footer">
<p id = "ftext">会社情報</p>
<p class = "ftext2">東京都台東区東上野1-2-11</p>
<p class = "ftext2">000-000-0000</p>
<p class = "ftext2">aaaaaa@ggg.com</p>
<p class = "ftext3">&copy; qualtet Co. Ltd. 2021</p>
</footer>
</body>
</html>