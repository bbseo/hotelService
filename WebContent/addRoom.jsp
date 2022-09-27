<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>update.jsp</title>
<script language=javascript>
function checkValid() {
    var f = window.document.addRoom;
		
	if ( f.roomname.value == "") {
	    alert( "방 호수를 입력해 주세요." );
		return false;
    }
	if ( f.img.value == "" ) {
		alert( "방 이미지 주소를 입력해 주세요." );
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		return false;
	}
	if ( f.category.value == "" ) {
        alert( "카테고리를 선택해 주세요" );
        return false;
    }
    return true;
}

</script>
</head>
<body>
<% String hotelNum = request.getParameter("num"); %>

<form name="addRoom" method="post" action="admin" onSubmit='return checkValid()'>

<input type="hidden" name="command" value="addRoom">
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1">
	
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>방 추가</b></font></p>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">방 호수</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="roomname" size="30"></span></b></td>
    </tr>
     <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">이미지</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="img" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">최대인원수</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="max_guest" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">카테고리</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="category" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
 		<input type="hidden" name="num" value="<%= hotelNum %>">
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=submit value="방 추가"> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

</body>
</html>