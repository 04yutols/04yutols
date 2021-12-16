<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿の情報更新ページ</title>
</head>
<body style="text-align:center;">

<h2>宿の情報更新</h2>
更新したい宿情報を入力してください。

<br><br><form action="/qualtet/ChangeHotelServlet" method="post">
名前：<input type="text" name="hotel_name" value = "${hoteldetail.get(0).getHotel_name()}"maxlength='50'>
<br><br>電話番号：<input type="text" name="tel" value = "${hoteldetail.get(0).getTel()}"maxlength='20'>
<br><br>住所：<input type="text" name="address" value = "${hoteldetail.get(0).getAddress()}"maxlength='200'>
<br><br>部屋数：<input type="text" name="room" value = "${hoteldetail.get(0).getRoom()}"maxlength='5'>
<br><br>アピールポイント：<input type="text" name="point" value = "${hoteldetail.get(0).getPoint()}"maxlength='5000'>
<br><br>画像のURL：<input type="file" name="picture_url" value = "${hoteldetail.get(0).getPicture_url()}"maxlength='200'>
<br><br>値段：<input type="text" name="price" value = "${hoteldetail.get(0).getPrice()}"maxlength='7'>

<br><br><input type="submit" value="確認">
<input type="hidden" name="action" value="changehotel">
</form>


</body>
</html>