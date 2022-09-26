<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="Login.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="main_header">
		<div class="header_content">
			<p id="header_title">야 여기어때?</p>
			<p id="header_hotel">🏨 Hotel</p>		
		</div>
	</header>
	
	<form action="login" method="post" name="loginForm">
	<input type="hidden" name="command" value="login">
		<h1 id="form_title">Log In</h1>
		<div class="login_input">
			<span class="input_text">아이디 : </span><input type="text" class="id_input" name="id" placeholder="ID를 입력하세요"> <br>
			<span class="input_text">비밀번호 :</span> <input type="password" class="pw_input" name="pwd" placeholder="PASSWORD를 입력하세요">		
			<input class="submit" type="submit" value="Log In">
		</div> 
	</form>
	<div class="other">
		<button class="sign_up">회원가입</button>
		<button class="find_pw">비밀번호 찾기</button>
	</div>
</body>
</html>