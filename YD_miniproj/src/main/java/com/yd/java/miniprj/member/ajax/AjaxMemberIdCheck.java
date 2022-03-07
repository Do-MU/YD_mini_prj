package com.yd.java.miniprj.member.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yd.java.miniprj.member.MemberDAO;
import com.yd.java.miniprj.member.MemberDAOImpl;


@WebServlet("/AjaxMemberIdCheck")
public class AjaxMemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxMemberIdCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO mDAO = new MemberDAOImpl();
		String id = request.getParameter("id");
		boolean check = mDAO.isIdCheck(id);
		if(check)
			out.print(1);
		else
			out.print(0);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
