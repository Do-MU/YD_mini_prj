<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<style>
.container {
	margin: auto;
	width: 50%;
}

.a {
	text-align: center;
}

textarea {
	resize: none;
	width: 50%;
}
</style>
<html>
<table class="container">
	<tr>
		<td>작성자</td>
		<td>${qna.memberID }</td>
		<td>작성일자</td>
		<td>${qna.qnaDate }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${qna.qnaTitle }</td>
	</tr>
</table>
<div class="a">
	<span>내용</span> <span>${qna.qnaContent }</span>
</div>
<form name="frm" action="qnaAnswerUpdate.do?qnaId=${qna.qnaId }"
	method="post">
	<div class="a">
		<c:if test="${qna.isAnswered==0}">
			<c:if test="${id eq'admin'}">
				<span>답변내용</span>
				<textarea name="answer" id="answer" cols="30" rows="10"></textarea>
				<input type="submit" value="답변"
					style="height: 40px; width: 60px; font-size: 20px;">
			</c:if>
		</c:if>
		<c:if test="${qna.isAnswered == 1}">
			<c:if test="${id eq 'admin' }">
				<span>답변내용</span>
		   		${qna.answerContent }
		   	</c:if>
   		</c:if>
	</div>
</form>
</html>