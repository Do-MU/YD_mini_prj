<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String togo = (String) request.getAttribute("togo");
  response.sendRedirect(togo);
%>