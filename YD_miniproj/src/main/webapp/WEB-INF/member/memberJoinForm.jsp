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
    }
</style>

<script type="text/javascript">
	function formCheck(){
		if(frm.idCheck.value == 'No'){
			alert("아이디 중복체크를 해주세요!");
			return false;
		}
		
		if(frm.password.value == ""){
			alert("패스워드는 필수 항목 입니다.");
			frm.password.focus();
			return false;
		}

		if(frm.name.value == ""){
			alert("이름은 필수 항목 입니다.");
			frm.name.focus();
			return false;
		}
		
		if(frm.password.value != frm.password1.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
		
		return true;
	}
	// ajax 로 처리 예정
	function idCheckCall() { 								//ajax로 아이디를 중복체크 하는 함수
    	const xhttp = new XMLHttpRequest(); 				//aJax객체를 생성
      	const id = frm.id.value;
      	xhttp.onreadystatechange = function() { 			//ajax가 동작될 때 실행하는 메소드
			if(xhttp.readyState==4){ 						//통신이 연결되서 데이터가 다 전달 되었다면
				if(xhttp.status==200){ 						//정상적으로 수행되고 결과가 왔을때
					var b = xhttp.responseText; 			//결과데이터 받는 부분
			        if(b == true){
						alert(id + "는 사용 가능한 아이디 입니다.");
			            frm.idCheck.value="Yes";
			            frm.idCheck.display="none";
			            frm.password.focus();
			        } else{
			            alert(id + "는 이미 사용 중인 아이디 입니다.");
			            frm.id.value="";
			            frm.id.focus();
			        }
				}
			}   
		}
		xhttp.open("GET","ajaxMemberIdCheck?id="+id);
		xhttp.send();
	}
</script>

<div id="container">
    <form id="frm" action="memberJoin.do" onsubmit="return formCheck();" method="post">
	    <div>
	        <h1>회원가입</h1>
	    </div>
        <table align="center">
	        <tr>
	            <th>이름</th>
	            <td><input type="text" id="name" name="name" required="required" placeholder="이름을 입력해주세요." ></td>
	        </tr>
	        <tr>
	            <th>아이디</th>
	            <td>
	               	<input type="text" id="id" name="id" required="required" placeholder="아이디를 입력해주세요.">
	            	<button type="button" onclick="idCheckCall()" id="idCheck" value="No">중복체크</button>
	            </td>
	        </tr>
	        <tr>
	            <th>비밀번호</th>
	            <td><input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력해주세요."></td>
	        </tr>
	        <tr>
	            <th>비밀번호 확인</th>
	            <td><input type="password" id="password1" name="password1" required="required" placeholder="비밀번호를 확인해주세요."></td>
	        </tr>
	        <tr>
	            <th>휴대폰 번호</th>
	            <td><input type="tel" id="tel" name="tel"></td>
	        </tr>
	        <tr>
	            <th>주소</th>
	            <td><input type="text" id="address" name="address"></td>
	        </tr>
	        <tr>
	            <th>이메일 주소</th>
	            <td><input type="email" id="email" name="email"></td>
	        </tr>
        </table>	
	    <div id="btn">
	        <button type="submit">회원가입</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button id="cancel_btn" onclick="history.back()">취소</button>
		</div>
	</form>
</div>