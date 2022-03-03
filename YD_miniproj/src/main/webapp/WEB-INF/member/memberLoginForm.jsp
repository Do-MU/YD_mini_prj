<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	form{
		padding: 200px 0 200px 0;
	}
	
	#login{
		margin: 10px 0 10px 0;
		padding: 10px 0 15px 0;
		text-align:center;
	}
	
	#login h1{
		font-size: 50px;
		font-family:"Arial";
		text-align:center;
	}
	
	#id_pass, #login_btn{
		display:inline-block;
		vertical-align:top;
	}
	
	#id_pass input{
		height:50px;
		width:350px;
	}
	#id{
		margin-top: 50px;
	}
	#pass{
		margin-top:10px;
	}
	#login button{
		margin-top: 50px;
		margin-left:5px;
		padding:12px;
		border-radius: 5px;
	}
	
	ul{
		list-style-type: none;
	}
	
	#btns{
    	margin: 40px 0 0 0;
    	text-decoration: underline;
	}
	
	#btns li{
   		margin-right: 20px;
    	display:inline;
    	font-size: 20px;
		text-align:center;
	}
</style>
</head>

<body>
   <form>
      <div id="login">
         <h1>로 그 인</h1>
         <div id="id_pass">
               <div id="id">
                  <input type="text" placeholder="아이디를 입력하세요.">
               </div>
               <div id="pass">
                  <input type="password" placeholder="비밀번호를 입력하세요.">
               </div>
         </div>
            
         <div id="login_btn">
             <button style="height:110px;">로그인</button>
         </div>
         
      	 <ul id="btns">
         	<li>아이디 찾기</li>
         	<li>비밀번호 찾기</li>
         	<li>회원 가입</li>
      	 </ul>
      </div>
   </form>
</body>
</html>