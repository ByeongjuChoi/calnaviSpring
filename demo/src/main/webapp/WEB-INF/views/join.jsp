<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会員登録</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body>
		<div>
			<h2>CALNAVI</h2>
		</div>
		<div>
			会員登録
		</div>
		<div>
			<label>ID: 
				<input type="text" name="userId" required="required">
			</label>
		</div>
		<div>
			<label>パスワード: 
				<input type="password" name="userPw" required="required">
			</label>
		</div>
		<div>
			<label>: ニックネーム
				<input type="password" name="userName" required="required">
			</label>
		</div>
		<div>
			<button id="joinBtn">会員登録</button>
		</div>
		
		
		<script>
			$(document).ready(function() {
				$("#joinBtn").on('click', function() {
					location.href = "join";
				});
			});
		</script>
	</body>
</html>