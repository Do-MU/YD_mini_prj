<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	#container{
		margin-top: 50px;
		width: 100%
	}
	
	#container> section> div{
		display: inline-block;
	}
	
	#img_box{
		margin-bottom: 50px;
	}
	
	#desc_box{
		margin: 50px 0 0 20px; 
	}
	
	img{
		vertical-align: bottom;
	}
	
	#desc_box> h1{
		margin-bottom: 50px;
	}
	
	input{
		text-align:right;	
		margin-bottom: 30px;
	}
	
	#price1{
		font-weight: bold;
		width: 120px;
		border: none;
	}
	
	#price2{
		font-weight: bold;
		width: 180px;
		border: none;
	} 
	
	#prd_quantity {	
		width: 70px;
	}
	
	#desc_box> ul> li> button{
		width: 90px;
		height: 50px;
		background-color: green;
		text-align: center;
		color: white;
		margin-left: 70px;
	}
	
	hr{
		width: 100%;
		height: 2px;
        background-color: gray;
	}
	
	#desc_img{
		text-align: center;
		margin: 0 auto;
	}
</style>

<div id="container">
	<section>
		<div id="img_box"><img src="img/${product.productImg }(1).png"></div>
			
		<div id="desc_box">
			<h1>[${product.productCategory }]${product.productName }</h1>
			<ul>
				<li><h3> 판매가 &nbsp;&nbsp;&nbsp;<input id="price1" value="${product.productPrice }"/>원</h3></li>
				<li><h3> 수량&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" min="1" max="50" value="1" id="prd_quantity" onclick="quantity_cal()">개</h3></li>
				<li><h2><b> 총 금액&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="price2" value="${product.productPrice}"/>원</b></h2></li>
				<li>
					<button id="order_btn">주문하기</button>
					<button id="basket_btn">장바구니</button>
				</li>
			</ul>
		</div>
	</section>
	<hr>
	<section>
		<div id="desc_img"><img src="img/${product.productImg }(2).png"></div>
	</section>
</div>

<script>
	let originPrice = parseInt(price1.value);
	let totalPrice = parseInt(price2.value);
	price1.value = originPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	price2.value = totalPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	function quantity_cal(){
		let qnt = parseInt(prd_quantity.value);
		totalPrice =  qnt*originPrice;
		price2.value = parseInt(totalPrice).toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	}
</script>

