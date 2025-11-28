<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${post.title}</title>
    <link rel="stylesheet" href="<c:url value='/CSS/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/CSS/community.css'/>">
</head>
<body>
	<jsp:include page="/HBox.jsp" />
    <jsp:include page="/header.jsp" />

    <main class="community-container">
        <div class="view-container">
            <div class="view-header">
                <h3>${post.title}</h3>
                <div class="view-info">
                    <span><strong>작성자:</strong> ${post.author}</span>
                    <span><strong>작성일:</strong> ${post.postdate} | <strong>조회수:</strong> ${post.visitcount}</span>
                </div>
            </div>
            <div class="view-content">
                ${post.content}
            </div>
        </div>

        <div class="view-actions">
            <a href="<c:url value='/board/list.do'/>" class="btn-list">목록</a>
            <c:if test="${sessionScope.user_id == post.id}">
                <a href="<c:url value='/board/edit.do?num=${post.num}'/>" class="btn-edit">수정</a>
                <form action="<c:url value='/board/delete.do'/>" method="post" style="display:inline;" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                <input type="hidden" name="num" value="${post.num}">
                <button type="submit" class="btn-delete">삭제</button>
            </form>
            </c:if>
        </div>
    </main>

    <jsp:include page="/footer.jsp"/>
</body>
</html>
