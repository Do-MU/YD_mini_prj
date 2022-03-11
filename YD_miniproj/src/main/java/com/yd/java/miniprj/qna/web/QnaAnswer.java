package com.yd.java.miniprj.qna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.qna.QnaDAOImpl;
import com.yd.java.miniprj.qna.QnaVO;

public class QnaAnswer implements Command{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		QnaDAOImpl qDAO = new QnaDAOImpl();
		QnaVO vo = new QnaVO();
		HttpSession session = request.getSession();
		
		
		vo.setQnaId(Integer.parseInt(request.getParameter("qna_id")));
		vo = qDAO.qnaSelectOne(vo);
		
		request.setAttribute("qna", vo);
		
		return "qna/qnaAnswer.tiles";
	}

}
