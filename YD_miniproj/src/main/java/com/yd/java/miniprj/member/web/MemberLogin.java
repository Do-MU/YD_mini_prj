package com.yd.java.miniprj.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.member.MemberDAO;
import com.yd.java.miniprj.member.MemberDAOImpl;
import com.yd.java.miniprj.member.MemberVO;

public class MemberLogin implements Command{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO mDAO = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		
		vo.setMemberID(request.getParameter("memberID"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = mDAO.memberLogin(vo);
		
		if(vo.getMemberName() != null) {
			session.setAttribute("id", vo.getMemberID());
			session.setAttribute("name", vo.getMemberName());
			
			return "member/loginSuccess.tiles";
		} else {
			return "member/loginFail.tiles";
		}
	}

}
