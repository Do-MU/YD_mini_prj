package com.yd.java.miniprj.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.basket.web.BasketAdd;
import com.yd.java.miniprj.basket.web.BasketList;
import com.yd.java.miniprj.command.HomeCommand;
import com.yd.java.miniprj.product.web.ProductInsert;
import com.yd.java.miniprj.product.web.ProductInsertForm;
import com.yd.java.miniprj.product.web.ProductList;
import com.yd.java.miniprj.product.web.ProductPage;
import com.yd.java.miniprj.member.ajax.AjaxMemberIdCheck;
import com.yd.java.miniprj.member.web.MemberChangePassword;
import com.yd.java.miniprj.member.web.MemberChangePasswordForm;
import com.yd.java.miniprj.member.web.MemberFindId;
import com.yd.java.miniprj.member.web.MemberFindIdForm;
import com.yd.java.miniprj.member.web.MemberFindPassword;
import com.yd.java.miniprj.member.web.MemberFindPasswordForm;
import com.yd.java.miniprj.member.web.MemberJoin;
import com.yd.java.miniprj.member.web.MemberJoinForm;
import com.yd.java.miniprj.member.web.MemberLogin;
import com.yd.java.miniprj.member.web.MemberLoginForm;
import com.yd.java.miniprj.member.web.MemberLogout;
import com.yd.java.miniprj.member.web.MemberUpdate;
import com.yd.java.miniprj.member.web.MemberUpdateForm;
import com.yd.java.miniprj.member.web.MyPage;
import com.yd.java.miniprj.qna.web.qnaInsert;
import com.yd.java.miniprj.qna.web.qnaList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령 그룹을 담아 두는 곳
		map.put("/home.do", new HomeCommand()); 									// 홈 페이지
		
		map.put("/memberJoinForm.do", new MemberJoinForm()); 						// 회원가입 화면
		map.put("/memberJoin.do", new MemberJoin());								// 회원가입 처리
		map.put("/memberLoginForm.do", new MemberLoginForm()); 						// 로그인 화면
		map.put("/memberLogin.do", new MemberLogin());								// 로그인 처리
		map.put("/memberLogout.do", new MemberLogout());							// 로그아웃 처리
		map.put("/memberFindIdForm.do", new MemberFindIdForm()); 					// 아이디찾기 화면
		map.put("/memberFindId.do", new MemberFindId()); 							// 아이디찾기 결과화면
		map.put("/memberFindPasswordForm.do", new MemberFindPasswordForm()); 		// 비밀번호찾기 화면
		map.put("/memberFindPassword.do", new MemberFindPassword()); 				// 비밀번호찾기 결과화면
		map.put("/myPage.do", new MyPage());										// 마이페이지
		map.put("/memberUpdateForm.do", new MemberUpdateForm());					// 회원정보 수정
		map.put("/memberUpdate.do", new MemberUpdate());							// 회원정보 수정 처리
		map.put("/memberChangePasswordForm.do", new MemberChangePasswordForm());	// 회원 비밀번호 수정
		map.put("/memberChangePassword.do", new MemberChangePassword());			// 회원 비밀번호 수정 처리
		
		map.put("/productList.do", new ProductList());								// 제품 목록 출력
		map.put("/productPage.do", new ProductPage());								// 제품 상세 페이지
		map.put("/productInsertForm.do", new ProductInsertForm());					// 제품 등록 화면
		map.put("/productInsert.do", new ProductInsert());							// 제품 등록 처리
		
		map.put("/basketList.do", new BasketList());								// 장바구니 목록
		map.put("/basketAdd.do", new BasketAdd());									// 장바구니 상품 추가
		
		map.put("/qnaList.do", new qnaList());										// 고객센터
		map.put("/qnaInsert.do", new qnaInsert());									// 문의글 등록
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제 요청을 분석하고 처리해서 결과 page를 돌려주는 역할
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		String uri = request.getRequestURI(); // URI
		String contextPath = request.getContextPath(); // Context Path
		String page = uri.substring(contextPath.length()); // 실제 처리해야 할 요청

		Command cmd = map.get(page);
		String viewPage = cmd.run(request, response);

		if (viewPage != null) {
			// aJax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp" + viewPage;

			System.out.println(viewPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}

	}
}
