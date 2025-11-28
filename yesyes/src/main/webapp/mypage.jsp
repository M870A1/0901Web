<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
     <jsp:include page="/HBox.jsp" />
    <link rel="stylesheet" href="<c:url value="/CSS/common.css"/>"> 
</head>
<body>
    <jsp:include page="/header.jsp"/>
    
    <main>
        <div class="container">
            <h2>${sessionScope.user_name}님의 마이페이지</h2>
            <p>환영합니다, ${sessionScope.user_name}님!</p>
            
            <div class="mypage-links">
                <a href="<c:url value="/board/list"/>" class="btn-primary">게시판으로 이동</a>
               <a href="<c:url value="/member/edit"/>" class="btn-secondary">회원 정보 수정</a> 
                <<a href="<c:url value="/member/myboard"/>" class="btn-secondary">내가 쓴 게시글</a> 
            </div>
        </div>
    </main>

    <jsp:include page="/footer.jsp"/>
</body>
</html>
