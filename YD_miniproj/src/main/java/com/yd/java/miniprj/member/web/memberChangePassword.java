package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class memberChangePassword implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAOImpl mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		vo.setMemberID(id);
		vo.setMemberPassword(request.getParameter("password"));
		
		int n = mDAO.memberUpdate(vo);
		if(n == 0) {
			return "member/changePasswordFail.tiles";
		}
		return "member/changePasswordSuccess.tiles";
	}

}
