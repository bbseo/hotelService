<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookingForm.jsp</title>

</head>
<body>
<%@include file ="./Header.jsp" %>
<form action="member" name="command" method="post">
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">


   <h3>예약일자 : ${requestScope.bookingForm[0].checkIn} ~ ${requestScope.bookingForm[0].checkOut}</h3>
   
   <h3><방 선택></h3>
   <c:forEach items="${requestScope.bookingForm}" var="bookingForm" varStatus="status">
          <article>
              <div>
                 <p>
                    <input type="radio" name="sensorDa" value="${bookingForm.roomName}">${bookingForm.roomName}
                    <input type="hidden" name="category" value="${bookingForm.category}">
                       <input type="hidden" name="hotelNum" value="${bookingForm.hotelNum }">
                       <input type="hidden" name="roomNum" value="${bookingForm.roomNum }">
                 </p>
              </div>

      </article>       
   </c:forEach> 
   예약인원 : 
   <select name="guestNum">
      <c:forEach var="i" begin="1" end="${requestScope.bookingForm[0].maxGuestNum}">
         <option value="${i}">${i}명</option>
      </c:forEach>
   </select>
   
   <div>
              <input type="hidden" name="command" value="hotel">
         <input type="submit" value="예약하기">
   </div>
</table>
</form>

</body>
</html>