<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.nav-item{
		font-size: 28px;
		padding: 0 50px 0 50px;
	}
</style>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="#"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link" href="home.do">홈</a></li>
			<li class="nav-item"><a class="nav-link" href="productList.do?category=홍삼">홍삼</a></li>
			<li class="nav-item"><a class="nav-link" href="productList.do?category=비타민">비타민</a></li>
			<li class="nav-item"><a class="nav-link" href="productList.do?category=콜라겐">콜라겐</a></li>
			<li class="nav-item"><a class="nav-link" href="#">후기</a></li>
		</ul>
	</div>
</nav>