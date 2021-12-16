<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿情報更新確認ページ</title>
</head>
<body>


<h2>以下の情報で更新します。</h2>


<table border="1">
<tr><td>名前</td><td>${hotel.hotel_name}</td></tr>
<tr><td>電話番号</td><td>${hotel.tel}</td></tr>
<tr><td>住所</td><td>${hotel.address}</td></tr>
<tr><td>部屋数</td><td>${hotel.room}</td></tr>
<tr><td>アピールポイント</td><td>${hotel.point}</td></tr>
<tr><td>画像のURL</td><td>${hotel.picture_url}</td></tr>
</table>

<form action="/qualtet/ChangeHotelServlet">
<br><br>
<input type="hidden" name="action" value="comp">
<input type="submit" value="確認">
</form>


</body>
</html>