<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
    #container{
    	padding: 150px;
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
        height: 20px;
    }
    
    #btn{
        margin-top: 40px;
        text-align: center;
    }
    </style>
</head> 
    <body>
    	<div id="container">
	        <form>
		        <div>
		            <h1>회원가입</h1>
		        </div>
	            <table align="center">
		            <tr>
		                <th>이름</th>
		                <td><input type="text" ></td>
		            </tr>
		            <tr>
		                <th>아이디</th>
		                <td><input type="text" ></td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td><input type="password"></td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td><input type="password"></td>
		            </tr>
		            <tr>
		                <th>휴대폰 번호</th>
		                <td><input type="tel"></td>
		            </tr>
		            <tr>
		                <th>주소</th>
		                <td><input type="text"></td>
		            </tr>
		            <tr>
		                <th>이메일 주소</th>
		                <td><input type="email"></td>
		            </tr>
	        	</table>
	        </form>
	        	
	        <div id="btn">
	            <button type="submit">회원가입</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <button id="login_btn" onclick="history.back()">취소</button>
	        </div>
        </div>
    </body>

</html>