package com.yd.java.miniprj.basket.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;

public class BasketList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		return "basket/basketList.tiles";
	}

}
