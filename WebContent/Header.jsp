<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
<link href="Header.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<header class="main_header">
		<div class="header_content">
			<p id="header_title">야 여기어때?</p>
			<p id="header_hotel">🏨 Hotel</p>
			<div class="logout_box">
				<form  name="logOut">
					<input type="hidden" name="command" value="logout">	
					<p id="logout" onclick="logout()">로그아웃</p>
					<p id="mypage" onclick="location='MyPage.jsp'">내정보</p>
				</form>	
			</div>	
		</div>
	</header>
	
	<script type="text/javascript">
		function logout() {
			const logoutForm = document.logOut;
			
			logoutForm.method = "post";
			logoutForm.action = "login";
			logoutForm.submit();
		}
	</script>
</body>
</html>