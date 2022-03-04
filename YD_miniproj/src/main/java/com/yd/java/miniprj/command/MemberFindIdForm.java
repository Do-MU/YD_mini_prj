package com.yd.java.miniprj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;

public class MemberFindIdForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		return "member/memberFindIdForm.tiles";
	}

}
