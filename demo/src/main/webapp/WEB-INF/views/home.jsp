<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main Page</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- 제이쿼리 설정 -->
	</head>
	<body>
		<button id="loginBtn">ログイン</button><br/>
		<button>会員登録</button>
	</body>
	
	<script>
		$(document).ready(function() {
			$("#loginBtn").on('click', function() {
				location.href = "loginPage";
			});
		});
	</script>
</html>