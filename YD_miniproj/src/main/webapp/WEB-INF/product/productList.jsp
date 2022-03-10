<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	body,ul,li {
	    list-style: none;
	    padding: 0;
	    margin: 0;
	}
	
	a {
	    text-decoration: none;
	    color: inherit;
	}
	
	.cell {
	    float: left;
	    box-sizing: border-box;
	    margin: 100px 0 100px;
	    cursor: pointer;
	}
	
	.img-box{
		height: 250px;
		background-color: black;
	}
	
	.img-box > img {
	    display: block;
	    width: 100%;
	    height: 100%;
	}
	
	.list > ul > li {
	    width: calc(100% / 3);
	}
	
	.list > ul > li {
	    padding: 0 40px;
	}
	
	.list > ul > li > div > .product-name {
	    text-align: Center;
	    font-weight: bold;
	    font-size: 1.4rem;
	}
	.list > ul > li:hover > div > .product-name {
	    text-decoration: underline;
	}
	
	.list > ul > li > div > .product-price {
	    text-align: center;
	    font-weight: bold;
	    font-size: 1.4rem;
	}
	
	.list > ul > li > div > .product-price::after {
	    content: " 원";
	    font-size: 1.3rem;
	    font-weight:normal;
	}
</style>

<div class="list con">
    <ul class="row">
    	<c:forEach var="vo" items="${products }">
	    	<li class="cell">
	    		<div onclick="location.href='productPage.do?prd_id=${vo.productID }'">
	    			<div class="img-box"><img src="img/${vo.productImg }(1).png"></div>
	            	<div class="product-name">[${vo.productCategory }] ${vo.productName }</div>
	            	<div class="product-price">${vo.productPrice}</div>
	            </div>
	    	</li>
    	</c:forEach>
    </ul>
</div>

<script>
	for(let i = 0; i<document.getElementsByClassName('cell').length; i++){
		console.log(document.getElementsByClassName('product-price')[i].innerText);
		let price = parseInt(document.getElementsByClassName('product-price')[i].innerText);
		console.log(typeof(price));
		console.log(price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","));
		document.getElementsByClassName('product-price')[i].innerText = price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	}
	
</script>