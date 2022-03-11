package com.yd.java.miniprj.qna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.qna.QnaDAOImpl;
import com.yd.java.miniprj.qna.QnaVO;

public class QnaAnswerUpdate implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		QnaDAOImpl qDAO = new QnaDAOImpl();
		QnaVO vo = new QnaVO();
		
		vo.setAnswerContent(request.getParameter("answer"));
		vo.setQnaId(Integer.parseInt(request.getParameter("qnaId")));
		
		int n = qDAO.qnaAnswer(vo);
		
		return "qnaList.do";
	}

}
