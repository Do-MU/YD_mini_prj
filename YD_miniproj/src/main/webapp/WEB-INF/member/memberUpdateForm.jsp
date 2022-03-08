<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        padding: 5px 10px 5px 60px;
    }
    
    th{
    	font_size: 40px;
    }
    
    input{
        height: 30px;
    }
    
    #btn{
        margin-top: 40px;
        text-align: center;
        margin-right: 10px;
    }
    
    td.informs{
    	font-weight: bold;
    }
</style>

<script>

</script>

<div id="container">
    <form id="frm" action="memberUpdate.do" method="post">
	    <div>
	        <h1>회원 정보 수정</h1>
	    </div>
        <table align="center">
	        <tr>
	            <th>이름</th>
	            <td class="informs">${name }</td>
	        </tr>
	        <tr>
	            <th>아이디</th>
	            <td class="informs">${id }</td>
	        </tr>
	        <tr>
	            <th>비밀번호</th>
	            <td>**********
	            <button type="button" onclick="location.href='memberChangePasswordForm.do'">비밀번호 변경</button>
	            </td>
	        </tr>
	        <tr>
	            <th>휴대폰 번호</th>
	            <td><input type="tel" id="tel" name="tel" required="required" value=${tel }></td>
	        </tr>
	        <tr>
	            <th>주소</th>
	            <td><input type="text" id="address" name="address" value="${address }"></td>
	        </tr>
	        <tr>
	            <th>이메일 주소</th>
	            <td><input type="email" id="email" name="email" value="${email }"></td>
	        </tr>
        </table>	
	    <div id="btn">
	        <button type="submit">변경하기</button>
			<button type="button" onclick="history.back()">취소</button>
		</div>
	</form>
</div>