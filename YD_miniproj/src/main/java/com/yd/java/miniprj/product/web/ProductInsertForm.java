package com.yd.java.miniprj.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;

public class ProductInsertForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("prd_category", request.getParameter("prd_category"));
		
		return "product/productInsertForm.tiles";
	}

}
