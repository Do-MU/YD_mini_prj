package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;

public class myPage implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {

		return "member/myPage.tiles";
	}

}
