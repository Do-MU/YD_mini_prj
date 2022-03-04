package com.yd.java.miniprj.member;

import java.util.List;

public interface MemberDAO {
	List<MemberVO> memberSelectAll();				// 회원 전체 조회
	MemberVO memberSelectOne(MemberVO mem);			// 회원 단건 조회
	int memberInsert(MemberVO mem);					// 회원 가입
	int memberUpdate(MemberVO mem);					// 회원 정보 변경
	int memberDelete(String memID);					// 회원 정보 삭제
	
	boolean isIdCheck(String id);					// 아이디 중복체크 > 해당 아이디가 존재하면 false
	MemberVO memberLogin(MemberVO vo);				// 로그인
}
