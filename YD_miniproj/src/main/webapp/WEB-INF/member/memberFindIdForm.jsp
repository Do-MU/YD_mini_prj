<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
        height: 20px;
    }
    </style>
    <title></title>
</head> 
    <body>
        <form>
        <div>
            <h1>아이디 찾기</h1>
        </div>
            <table align="center">
            <tr>
                <td>이름</td>
                <td><input type="text" ></td>
            </tr>
            <tr>
                <td>휴대폰 번호</td>
                <td><input type="tel" ></td>
            </tr>
        </table>
            <div id="btn">
             <button id="btn" type="submit" style="font-size:1.2em;">아이디찾기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <button type="submit" style="font-size: 1.2em;">취소</button>
            </div>
        </form>
    </body>

</html>