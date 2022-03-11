package com.yd.java.miniprj.qna.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.common.Command;

public class QnaInsertSuccess implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		
		return "qna/qnaInsertSuccess.tiles";
	}

}
