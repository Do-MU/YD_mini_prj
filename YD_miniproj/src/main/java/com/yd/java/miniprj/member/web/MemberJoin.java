package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAO;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberJoin implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		
		vo.setMemberID(request.getParameter("id"));
		vo.setMemberPassword(request.getParameter("password"));
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberTel(request.getParameter("tel"));
		vo.setMemberAddress(request.getParameter("address"));
		vo.setMemberEmail(request.getParameter("email"));
		
		request.setAttribute("name", request.getParameter("name"));
		
		int n = mDAO.memberInsert(vo);
		if(n!=0) {
			return "member/joinSuccess.tiles";
		} else {
			return "member/joinFail.tiles";
		}
		
		
	}

}
