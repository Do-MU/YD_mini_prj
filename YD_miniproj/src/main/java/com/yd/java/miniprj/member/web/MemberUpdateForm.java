package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberUpdateForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		vo = mDAO.memberSelectOne(id);

		if(id != null) {
			session.setAttribute("id", vo.getMemberID());
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("password", vo.getMemberPassword());
			session.setAttribute("tel", vo.getMemberTel());
			session.setAttribute("address", vo.getMemberAddress());
			session.setAttribute("email", vo.getMemberEmail());
		}
		
		return "member/memberUpdateForm.tiles";
	}

}
