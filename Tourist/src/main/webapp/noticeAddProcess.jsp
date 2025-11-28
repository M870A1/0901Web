<%@page import="model1.BoardDAO"%>
<%@page import="model1.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="utils.JSFunction, member.MemberDAO, member.MemberDTO" %>
<%@ include file="./IsLoggedIn.jsp" %>
<%
request.setCharacterEncoding("UTF-8");

String title = request.getParameter("title");
String content = request.getParameter("content");
String emailId = (String) session.getAttribute("user_id");
if (emailId == null) {
    JSFunction.alertLocation("로그인이 필요합니다.", "login.jsp", out);
    return;
}

BoardDTO dto = new BoardDTO();
dto.setTitle(title);
dto.setContent(content);
dto.setId(emailId);

BoardDAO dao = new BoardDAO();
int iResult = dao.insertWrite(dto);
dao.close();

if (iResult == 1) {
    response.sendRedirect("notice_list.jsp");
} else {
    JSFunction.alertBack("글쓰기에 실패하였습니다.", out);
}


%>
