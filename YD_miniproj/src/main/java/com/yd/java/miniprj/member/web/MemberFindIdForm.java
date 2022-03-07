package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberFindIdForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/memberFindIdForm.tiles";
	}

}
