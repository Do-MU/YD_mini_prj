<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	ul{
		list-style-type: none;
	}
	
	#login_div li{
    	display:inline;
		text-align:center;
	}
	
</style>    
<div id="logoContainer">
	<div>
		<a id="logo" href='home.do'>도박장</a>
	</div>
	<c:if test="${empty id}">
		<div id="login_div">
			<button id="login_btn" onclick="location.href='memberLoginForm.do'">로그인</button>&nbsp;&nbsp;
			<button id="join_btn" onclick="location.href='memberJoinForm.do'">회원가입</button>
		</div>
	</c:if>
	<c:if test="${not empty id}">
		<div id="login_div">
			<ul>
				<li><span id="id_print" style="font-weight:bold">${name } 님&nbsp;&nbsp;&nbsp;&nbsp;</span></li>
				<li><button id="logout_btn" onclick="location.href='memberLogout.do'">로그아웃</button>&nbsp;&nbsp;</li>
				<li><button id="basket_btn" onclick="location.href='basketList.do'">장바구니</button>&nbsp;&nbsp;</li>
				<li><button id="mypage_btn" onclick="location.href='myPage.do'">마이페이지</button>&nbsp;&nbsp;</li>
				<li><button id="qna_btn" onclick="location.href='qnaList.do'">고객센터</button></li>
			</ul>
			</div>
	</c:if>
</div>
<div id="under"></div>