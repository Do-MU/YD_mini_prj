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

import com.yd.java.miniprj.command.HomeCommand;
import com.yd.java.miniprj.member.MemberLoginForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령 그룹을 담아 두는 곳
		map.put("/home.do", new HomeCommand()); // 처음 접근하는 페이지
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼

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
