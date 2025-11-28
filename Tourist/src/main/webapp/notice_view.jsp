<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardDTO"%>
<%@ page import="model1.BoardDAO"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
 
<%
    // 파라미터로 가지고온 게시글 PrimaryKey를 저장
    String num = request.getParameter("num");

    // DB연결 및 데이터 조회
    BoardDAO dao = new BoardDAO();
    dao.updateVisitCount(num); // 조회수 1증가
    BoardDTO dto = dao.selectView(num);
    dto.setContent(dto.getContent().replace("\r\n","<br/>"));
    dao.close();

    // request에 dto 저장 (EL에서 접근 가능하도록)
    request.setAttribute("dto", dto);
    request.getRequestDispatcher("notice_view_result.jsp").forward(request, response);
%>

