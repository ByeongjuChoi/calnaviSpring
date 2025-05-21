<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<h2>ログイン</h2>
		<c:if test="${not empty error}">
			<p style="color:red">${error}</p>
		</c:if>
		<form action="/login" method="post">
			<label>ID: <input type="text" name="userId"></label><br/>
			<label>PASSWORD: <input type="password" name="userPw"></label><br/>
			<input type="submit" value="ログイン">
		</form>
		<input type="button" value="会員登録">
	</body>
</html>