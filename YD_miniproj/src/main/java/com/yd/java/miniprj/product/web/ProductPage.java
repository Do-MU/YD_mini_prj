package com.yd.java.miniprj.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.product.ProductDAOImpl;
import com.yd.java.miniprj.product.ProductVO;

public class ProductPage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		ProductDAOImpl pDAO = new ProductDAOImpl();
		ProductVO vo = new ProductVO();
		
		int prd_id = Integer.parseInt((String) request.getParameter("prd_id"));
		
		
		vo = pDAO.productSelectOne(prd_id);
		/*
		System.out.println(vo.getProductID());
		System.out.println(vo.getProductName());
		System.out.println(vo.getProductImg());
		System.out.println(vo.getProductPrice());
		System.out.println(vo.getProductCategory());
		*/
		
		request.setAttribute("product", vo);
		
		return "product/productPage.tiles";
	}

}
