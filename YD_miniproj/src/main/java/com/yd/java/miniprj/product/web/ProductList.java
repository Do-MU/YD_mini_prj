package com.yd.java.miniprj.product.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.product.ProductDAOImpl;
import com.yd.java.miniprj.product.ProductVO;

public class ProductList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		String category = "";
		/*
		String c = request.getRequestURI();
		c = c.substring(c.length()-4, c.length());
		c = c.substring(0, 1);
		
		switch(c) {
		case "H":
			category = "홍삼";
			break;
		case "V":
			category = "비타민";
			break;
		case "K":
			category = "콜라겐";
			break;
		default:
			return "layout/home";
		}
		
		System.out.println(c);
		*/
		category = request.getParameter("category");
		
		ProductDAOImpl pDAO = new ProductDAOImpl();
		List<ProductVO> pList = new ArrayList<ProductVO>();
		HttpSession session = request.getSession();
		
		pList = pDAO.productSelectAll(category);
		/*
		for(ProductVO p : pList) {
			System.out.println(p.getProductID());
			System.out.println(p.getProductName());
			System.out.println(p.getProductImg());
			System.out.println(p.getProductPrice());
			System.out.println(p.getProductCategory());
		}
		*/
		session.setAttribute("products", pList);
		
		return "product/productList.tiles";
	}
}
