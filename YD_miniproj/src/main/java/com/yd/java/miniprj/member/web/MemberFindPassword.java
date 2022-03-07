package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberFindPassword implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAOImpl mDAO  = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setMemberID(request.getParameter("fid"));
		vo.setMemberName(request.getParameter("fname"));
		vo.setMemberTel(request.getParameter("ftel"));
		String password = mDAO.memberSelectPW(vo);
		
		session.setAttribute("fpassword", password);
		session.setAttribute("fname", vo.getMemberName());
		
		return "member/memberFindPassword.tiles";
	}

}
