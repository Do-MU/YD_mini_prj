package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberFindId implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setMemberName(request.getParameter("fname"));
		vo.setMemberTel(request.getParameter("ftel"));
		String id = mDAO.memberSelectID(vo);
		
		session.setAttribute("fid", id);
		session.setAttribute("fname", vo.getMemberName());
			
		return "member/memberFindID.tiles";
	}

}
