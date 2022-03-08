package com.yd.java.miniprj.qna;

import java.util.List;

import com.yd.java.miniprj.member.MemberVO;

public interface QnaDAO {
	List<QnaVO> qnaSelectAll();					// qna전체 조회
	QnaVO qnaSelectOne(QnaVO qna);				// qna단건 조회
	int qnaInsert(QnaVO qna);					// qna등록
}
