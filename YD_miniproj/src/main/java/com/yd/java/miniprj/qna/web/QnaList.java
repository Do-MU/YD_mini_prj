package com.yd.java.miniprj.qna.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;
import com.yd.java.miniprj.qna.QnaDAOImpl;
import com.yd.java.miniprj.qna.QnaVO;

public class QnaList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		QnaDAOImpl qDAO = new QnaDAOImpl();
		List<QnaVO> qList = new ArrayList<QnaVO>();
		
		qList = qDAO.qnaSelectAll();
		
		request.setAttribute("qna", qList);
		return "qna/qnaList.tiles";
	}

}
