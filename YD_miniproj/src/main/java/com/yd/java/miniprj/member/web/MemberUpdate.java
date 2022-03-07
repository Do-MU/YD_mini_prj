package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setMemberID((String) session.getAttribute("id"));
		vo.setMemberTel(request.getParameter("tel"));
		vo.setMemberAddress(request.getParameter("address"));
		vo.setMemberEmail(request.getParameter("email"));
		
		int n = mDAO.memberUpdate(vo);
		if(n!=0) {
			return "member/updateSuccess.tiles";
		}
		return "member/updateFail.tiles";
	}

}
