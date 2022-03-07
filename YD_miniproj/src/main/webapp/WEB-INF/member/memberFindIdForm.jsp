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

<form id="frm" action="memberFindId.do" method="post">
	<div>
		<h1>아이디 찾기</h1>
    </div>
    <table align="center">
    	<tr>
            <td>이름</td>
            <td><input type="text" name="fname"></td>
        </tr>
        <tr>
            <td>휴대폰 번호</td>
            <td><input type="tel" name="ftel"></td>
        </tr>
    </table>
    <div id="btn">
       	<button type="submit">아이디찾기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<button type="button" onclick="history.back()">취소</button>
    </div>
</form>