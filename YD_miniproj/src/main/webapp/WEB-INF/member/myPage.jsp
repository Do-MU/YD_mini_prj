<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#myPage_container{
		padding: 150px 0 150px 0;
	}

	#myPage_container div{
		width: 1000px;
		hieght: 200px;
		
		background-color: gray;
		color: white;
		font-size: 40px;
		padding: 20px;
		margin : 50px;
		text-align: center;
		cursor: pointer;
	}
</style>
    
<div id="myPage_container">
	<div id="memberUpdate_div" onclick="location.href='memberUpdateForm.do'">
		회원 정보 수정
	</div>
	
	<div id="purchaseList_div" onclick="location.href='purchaseList.do'">
		구매 목록
	</div>
	
	<div id="basketList_div" onclick="location.href='basketList.do'">
		장바구니
	</div>
	
	<div id="myReviewList_div" onclick="location.href='myReivewList.do'">
		나의 후기
	</div>
</div>