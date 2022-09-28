<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bookingList.jsp</title>
</head>
<body>
<%@ include file="./Header.jsp" %>
<%@ include file="./Menu.jsp" %>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
      <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">
               <form name="search_member_list" method="post" action="admin">
               <input type="hidden" name="command" value="bookingList">
                  <td width="450" height="20" ><b><span style="font-size:9pt;">
               		<input type=text name="name" size="50"></span></b></td>
                  <td>
                  	<input type="submit" value="검색">
                  </td>
               </form>
            </span></b></font></p>
        </td>
   </tr>
</table>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">예약 코드</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">멤버이름</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">방 코드</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">체크인 날짜</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">체크아웃 날짜</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">예약신청날짜</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">예약취소날짜</span></b></font></p>
        </td>
    </tr>
    
 	<c:if test="${empty bookingList || fn:length(bookingList) == 0}">
		<tr>
	        <td colspan="8">
	            <p align="center"><b><span style="font-size:9pt;">등록된 예약일정이 없습니다</span></b></p>
	        </td>
	    </tr>
	</c:if>

	<%-- ArrayList에  GuestBookBean 객체를 하나하나 data라는 반복 대입해서 사용 --%>
	<c:forEach items="${requestScope.bookingList}" var="data">
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${data.bookingNum}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.memberName}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.roomNum}</span></p>
		        </td>
		        
		        <td bgcolor="">
					<p><span style="font-size:9pt;">${data.checkin_date}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.checkout_date}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.booked_date}</span></p>
		        </td> 
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.booked_cancel_date}</span></p>
		        </td>
		    </tr>
	</c:forEach>
</table>
<hr>
</body>
</html>
