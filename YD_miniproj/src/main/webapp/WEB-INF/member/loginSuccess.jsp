<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
<body>
    <div id="txtcontainer">
        <h1>${name }님 반갑습니다!!</h1>
        <button type="button" onclick="location.href='home.do'">홈으로</button>
    </div>
</body>