<%@page import="model1.BoardDTO"%>
<%@page import="model1.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="IsLoggedIn.jsp"%>
<%
String num = request.getParameter("num");
BoardDAO dao = new BoardDAO();
BoardDTO dto = dao.selectView(num);
String sessionId = (session.getAttribute("user_id") != null) ?
	   session.getAttribute("user_id").toString() : "";
System.out.println(sessionId);
System.out.println(dto.getId());
dao.close();

if (!sessionId.equals(dto.getId())) {
    JSFunction.alertBack("작성자 본인만 수정할 수 있습니다.", out);
    return;
}

request.setAttribute("dto",dto);
request.getRequestDispatcher("Eidt_result.jsp")
.forward(request , response );
%>
