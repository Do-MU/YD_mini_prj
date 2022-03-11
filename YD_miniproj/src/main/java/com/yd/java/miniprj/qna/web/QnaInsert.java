package com.yd.java.miniprj.qna.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.qna.QnaDAOImpl;
import com.yd.java.miniprj.qna.QnaVO;

public class QnaInsert implements Command{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		QnaDAOImpl qDAO = new QnaDAOImpl();
		QnaVO vo = new QnaVO();
		HttpSession session = request.getSession();
		
		vo.setQnaTitle(request.getParameter("qtitle"));
		vo.setQnaContent(request.getParameter("qcontent"));
		vo.setMemberID((String) session.getAttribute("id"));
		
		int n = qDAO.qnaInsert(vo);
		request.setAttribute("togo", "home.do");
		return "qna/sendRedirect.jsp";
	}

}
