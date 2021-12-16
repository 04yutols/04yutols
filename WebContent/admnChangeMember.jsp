<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の更新</title>
</head>
<body style="text-align:center;">

<h2>会員情報の更新</h2>
変更したい情報を入力して下さい。


<br><br>
<form action="/qualtet/AdmnMemberServlet" method="post">
名前：<input type="text" name="user_name" value = "${user.get(0).getName()}" >
<br><br>住所：<input type="text" name="address" value = "${user.get(0).getAddress()}">
<br><br>電話番号：<input type="text" name="tel" value = "${user.get(0).getTel()}">
<br><br>メールアドレス：<input type="text" name="email" value = "${user.get(0).getEmail()}">
<br><br>生年月日：<input type="date" name="birthday" value = "${user.get(0).getBirthday()}">
<br><br>パスワード（半角英数字）：<input type="text" name="password" value = "${user.get(0).getPassword()}" >
<br><br>

<input type="submit" value="更新">
<input type="hidden" name="action" value="cngmember">
</form>
</body>
</html>