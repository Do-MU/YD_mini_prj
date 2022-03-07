<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#txtcontainer{
    text-align: center;
    padding-top: 250px;
    padding-bottom: 250px;
}

 h1{
    font-size: 30px;
    padding-bottom: 50px;
}

#txtcontainer button{
    width: 70px;
    height: 30px;
}

#txtcontainer button:nth-child(3){
    width: 140px;
    height: 30px;
}

#foundpw{
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
<body>
    <div id="txtcontainer">
    	<c:if test="${not empty fpassword }">
        	<h1><b>${fname }</b> 회원님의 비밀번호는 <span id="foundpw">${fpassword }</span> 입니다.</h1>
        	<button type="button" onclick="location.href='memberLoginForm.do'">로그인</button>
        	<button type="button" onclick="location.href='home.do'">홈으로</button>
        </c:if>
        
        <c:if test="${empty fpassword }">
        	<h1>존재하지 않거나 찾을수 없는 ID입니다.</h1>
        	<button type="button" onclick="location.href='home.do'">홈으로</button>
        </c:if>
    </div>
</body>