<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
<link href="Menu.css" rel="stylesheet" type="text/css">
<meta charset="utf-8">
<title>Header</title>
</head>
<body>
	<header class="admin_menu">
		<div class="menu_content">
			<ul>
				<li><a href="admin?command=memberList">사용자관리</a></li>
				<li><a href="admin?command=bookingList">예약관리</a></li>
				<li><a href="admin?command=hotelList">호텔관리</a></li>
			</ul>
		</div>
	</header>
</body>
</html>