package co.micol.dbtest.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.common.DbCommand;
import co.micol.dbtest.member.service.MemberService;
import co.micol.dbtest.member.serviceImpl.MemberServiceImpl;

public class MemberList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 목록 보기
		MemberService memberDAO = new MemberServiceImpl();		// member 테이블에 접근하기 위해 DAO 생성
		request.setAttribute("members", memberDAO.selectMemberList());		// 전체 조회 실행하여 결과를 감음
		return "member/memberList.tiles";
	}

}
