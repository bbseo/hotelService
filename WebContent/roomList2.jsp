<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>roomList2.jsp</title>
</head>
<body>
<%@ include file="./Header.jsp" %>
<%@ include file="./Menu.jsp" %>
<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
      <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">
               <form name="search_room_list" method="post" action="admin">
               <input type="hidden" name="command" value="roomList">               
               <input type="hidden" name="num" value="${requestScope.test}">               
                  <td width="450" height="20" ><b><span style="font-size:9pt;">
               		이름:<input type=text name="room_name" size="50">
               		카테고리 :<select id="category" name="category">
                     <option value="all">모두</option>
                     <option value="Standard">스탠다드</option>
                     <option value="Delux">디럭스</option>
                     <option value="Suite">스위트</option>
                  </select></span></b></td>
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
            <p align="center"><font color="white"><b><span style="font-size:9pt;">호텔코드</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">방이름</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">방이미지</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">방상태</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">손님수</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">최대손님수</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">카테고리</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">수정하기</span></b></font></p>
        </td>
    </tr>
    
 	<c:if test="${empty roomList || fn:length(roomList) == 0}">
		<tr>
	        <td colspan="8">
	            <p align="center"><b><span style="font-size:9pt;">등록된 방이 없습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>

	<%-- ArrayList에  GuestBookBean 객체를 하나하나 data라는 반복 대입해서 사용 --%>
	<c:forEach items="${requestScope.roomList}" var="data">
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.hotelNum}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.roomName}</span></p>
		        </td>
		        
		        <td bgcolor="">
					<p><span style="font-size:9pt;"><img alt="방사진" src="${data.roomImage}"></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.roomState}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.guestNum}</span></p>
		        </td> 
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.maxGuestNum}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.price}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.category}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <a href="admin?command=roomchange&num=${data.roomNum}">수정하기</a></span></p>
		        </td>
		    </tr>
	</c:forEach>
</table>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="addRoom.jsp?num=${requestScope.roomList[0].hotelNum}">방 추가</a>&gt;</span></div>
</body>
</html>
