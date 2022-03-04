<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#logoContainer {
		margin: 25px;
	}
	
	#logo {
		font-size: 50px;
		font-weight: bold;
		padding: 10px;
		float: left;
		color: brown;
		background-color: gold;
	}
	
	a:hover{
		text-decoration-line: none;
	} 
	
	#login_div {
		float: right;
		padding-top: 20px;
	}
	
	#under{
		clear: left;
		height: 25px;
	}
	
</style>    
<div id="logoContainer">
	<div>
		<a id="logo" href='home.do'>도박장</a>
	</div>
	<div id="login_div">
		<button id="login_btn" onclick="location.href='memberLoginForm.do'">로그인</button> &nbsp;&nbsp;
		<button id="join_btn" onclick="location.href='memberJoinForm.do'">회원가입</button>
	</div>
</div>
<div id="under"></div>