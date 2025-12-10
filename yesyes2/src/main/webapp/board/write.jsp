<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
    <link rel="stylesheet" href="<c:url value='/CSS/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/CSS/community.css'/>">
</head>
<body>
	<jsp:include page="/HBox.jsp" />
    <jsp:include page="/header.jsp" />

    <main class="community-container">
        <h2>새 글 작성</h2>

        <form action="<c:url value='/board/write.do'/>" method="post" class="write-form">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required placeholder="제목을 입력하세요">
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" required placeholder="내용을 입력하세요"></textarea>
            </div>
            
            <div class="write-actions">
                <button type="submit" class="btn-submit">등록하기</button>
            </div>
        </form>
    </main>

    <jsp:include page="/footer.jsp"/>
</body>
</html>