<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	form{
		padding: 200px;
	}
	
    #btn{
        margin-top: 30px;
        text-align: center;
    }

    h1{
        margin-bottom: 50px;
        font-size: 50px;
        text-align: center;
    }

    td{
        font-size: 20px;
        padding: 5px 10px 5px 60px;
    }

    input{
        height: 30px;
    }
</style>

<script>
	function formCheck(){
		if(frm.password.value != frm.password1.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
		return true;
	}
</script>

<form id="frm" action="memberChangePassword.do" onsubmit="return formCheck();" method="post">
	<div>
		<h1>아이디 찾기</h1>
    </div>
    <table align="center">
    	<tr>
            <td>비밀번호</td>
            <td><input type="password" id="password" name="password" required="required"></td>
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" id="password1" name="password1" required="required"></td>
        </tr>
    </table>
    <div id="btn">
       	<button type="submit">비밀번호 변경</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<button type="button" onclick="history.back()">취소</button>
    </div>
</form>