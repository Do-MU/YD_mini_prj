<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
    .qna{
        text-align: center;
    }
    .title{
        padding-top: 50px;
    }
    .content{
        padding-top: 20px;
    }
    textarea{
        resize: none;
        height:500px; 
        width: 600px; 
        font-size:20px;
    }
</style>

<form name="frm" action="/qnaInsert.do">
    <div class="qna">
        <h1>문의하기</h1>
        <div class="title">
        <span style="font-size: 1.3em; font-weight: 1000;">제목</span>
            <input type="text" style="height: 30px; width: 600px; font-size:20px;" placeholder="제목을 입력해주세요."><br>
        </div>
        <div class="content">
        <span style="font-size: 1.3em; font-weight: 1000;">내용</span>
            <textarea placeholder="내용을 입력해주세요."></textarea>
            <p><input type="submit" value="등록" style="height: 50px; width: 100px; font-size: 25px;"></p>
        </div>    
    </div>
</form>