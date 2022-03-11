<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
${prd_category} 제품 등록 페이지

<div>
	<form action="productInsert.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<th>상품 이미지</th>
				<td><input type="file" name="image1"></td>
			</tr>
			<tr>
				<th>상품 설명 이미지</th>
				<td><input type="file" name="image2"></td>
			</tr>
			<tr>
				<th>상품 가격</th>
				<td><input type="text" id="price" name="price"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="hidden" id="category" name="category" value="${prd_category }"></td>
			</tr>
		</table>
		<div id="btns">
			<button type="submit">등록</button>
			<button type="button" onclick="history.back()">취소</button>
		</div>
	</form>
</div>