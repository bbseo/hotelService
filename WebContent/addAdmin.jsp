<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>update.jsp</title>
<script language=javascript>
function checkValid() {
    var f = window.document.addAdmin;
		
	if ( f.name.value == "") {
	    alert( "이름을 입력해 주세요." );
		return false;
    }
	if ( f.id.value == "" ) {
		alert( "아이디를 입력해 주세요." );
		return false;
	}
	if ( f.pw.value == "" ) {
		alert( "비밀번호를 입력해 주세요." );
		return false;
	}
	if ( f.tel.value == "" ) {
        alert( "전화번호를 입력해 주세요" );
        return false;
    }
	if ( f.email.value == "" ) {
        alert( "이메일을 입력해 주세요" );
        return false;
    }
    return true;
}

</script>
</head>
<body>

<form name="addAdmin" method="post" action="admin" onSubmit='return checkValid()'>

<input type="hidden" name="command" value="addAdmin">

<table align="center" cellpadding="5" cellspacing="2" width="600" border="1">

    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#336699">
            <p align="center"><font color="white" size="3"><b>관리자 생성</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="name" size="30"></span></b></td>
    </tr>
     <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">아이디</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="id" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="pw" size="30"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">전화번호</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="tel" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">이메일</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="email" size="50"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">&nbsp;</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=submit value=관리자 생성> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>

</body>
</html>