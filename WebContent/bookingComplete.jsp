<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file ="./Header.jsp" %>
<div>
	<h1>예약이 완료 되었습니다.</h1>
	<h3>예약자 : ${requestScope.complete[0].memberName }</h3>
	<h3>전화번호 : ${requestScope.complete[0].tel }</h3>
	<h3>예약 일 : ${requestScope.complete[0].bookedDate }</h3>
	<hr/>
	<h3>호텔 명 : ${requestScope.complete[0].hotelName }</h3>
	<h3>호텔등급 : ${requestScope.complete[0].hotelGrade }</h3>
	<h3>호텔위치 : ${requestScope.complete[0].hotelLocation }</h3>
	<hr/>
	<h3>객실번호 : ${requestScope.complete[0].roomName }</h3>
	<h3>입실 일 : ${requestScope.complete[0].checkinDate }</h3>
	<h3>퇴실 일 : ${requestScope.complete[0].checkoutDate }</h3>
	<hr/>
	<h3>사용인원 : ${requestScope.complete[0].guestNum } / ${requestScope.complete[0].maxGuestNum }</h3>
	<h3>금액 : ${requestScope.complete[0].price }</h3>
	<hr/>
	
	<%-- <c:if test="${requestScope.complete[0].guestNum}>2"></c:if>
	<h2>추가 금액 : ${requestScope.complete[0].price}</h2> --%>
	
	
	
</div>

</body>
</html>