<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberList.jsp</title>
<style type="text/css">
	.member_search_wrapper {width: 1280px; margin: 0 auto; }
	.member_search {text-align: right; }
	.search_flex {display:flex; justify-content: flex-end; margin-bottom: 10px;}
	.add_admin {font-family: 'Dongle', sans-serif; font-size: 1.5rem; background: #F8EDE3; border-radius: 0.5rem; cursor: pointer; border-width: 1px;}
	.search_btn {font-family: 'Dongle', sans-serif; font-size: 1.5rem; background: #F8EDE3; border-radius: 0.5rem; cursor: pointer; border-width: 1px; margin-left: 1rem;}
	.search_text{width: 10rem;  border:0; border-bottom: 1px solid #333; margin-left: 1rem; outline: 0;}
	td {border-radius: 0.5rem;}
</style>
</head>
<body>
<%@ include file="./Header.jsp" %>

<div class="member_search_wrapper">
<%@ include file="./Menu.jsp" %>
		
	<div class="member_search">
		<form name="search_member_list" method="post" action="admin">
		    <div class="search_flex">
		    <input type="hidden" name="command" value="memberList">
		       <select id="se" name="se">
		          <option value="all">모두</option>
		          <option value="member">사용자</option>
		          <option value="admin">관리자</option>
		       </select>
				<input class="search_text" type=text name="name" size="50" placeholder="이름검색">
		   		<input class="search_btn" type="submit" value="검색">
		    </div>
		</form>
	</div>
	
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
		<tr>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">회원 코드</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">아이디</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">비밀번호</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">이름</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">전화번호</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">이메일</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">등급</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">구분</span></b></font></p>
	        </td>
	        <td bgcolor="#F8EDE3">
	            <p align="center"><font color="#BE8C63"><b><span style="font-size:9pt;">수정하기</span></b></font></p>
	        </td>
	    </tr>
	    
	 	<c:if test="${empty memberList || fn:length(memberList) == 0}">
			<tr>
		        <td colspan="8">
		            <p align="center"><b><span style="font-size:9pt;">등록된 사용자가 없습니다.</span></b></p>
		        </td>
		    </tr>
		</c:if>
	
		<%-- ArrayList에  GuestBookBean 객체를 하나하나 data라는 반복 대입해서 사용 --%>
		<c:forEach items="${requestScope.memberList}" var="data">
			    <tr>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${data.memberNum}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">${data.id}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">${data.pw}</span></p>
			        </td>
			        
			        <td bgcolor="">
						<p><span style="font-size:9pt;">${data.memberName}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">${data.tel}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			             ${data.email}</span></p>
			        </td> 
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			             ${data.memberGrade}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			             ${data.authority}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            <a href="admin?command=memberchange&num=${data.memberNum}">수정하기</a></span></p>
			        </td>
			    </tr>
		</c:forEach>
	</table>
	<hr>
	<div style="display: flex; justify-content: flex-end"><button class="add_admin" onclick="location.href='addAdmin.jsp'">관리자 생성</button></div>
	
</div>

</body>
</html>
