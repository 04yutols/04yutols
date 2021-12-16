<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿の追加</title>
</head>
<div class = "content">
<body style="text-align:center;">

<h2>宿の追加登録</h2>
追加したい宿の情報を入力してください。

<br><br><form action="/qualtet/AddHotelServlet"method="post">
名前：<input type="text" name="hotel_name" maxlength='50' >
<br><br>電話番号：<input type="text" name="tel" maxlength='20'>
<br><br>住所：<input type="text" name="address" maxlength='200'>
<br><br>部屋数：<input type="text" name="room" maxlength='4'>
<br><br>アピールポイント：<input type="text" name="point" maxlength='200'>
<br><br>画像のURL：<input type="file" name="picture_url" maxlength='200'>
<br><br>一部屋の値段：<input type="text" name="price"maxlength='7'>
<br><br>宿カテゴリ：
<select name="category">
<option value="1">シティホテル</option>
<option value="2">リゾートホテル</option>
<option value="3">ビジネスホテル</option>
<option value="4">旅館</option>
<option value="5">民宿</option>
<option value="6">ペンション</option>
</select>

<br><br><input type="submit" value="追加">
<input type="hidden" name="action" value="add">
</form>
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