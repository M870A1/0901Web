<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <header>
        <h1>Promoting the Game!</h1>
        <div class="user-menu">
            <c:choose>
                <c:when test="${empty sessionScope.user_id}">
                    <a href="<c:url value="/member/login.do"/>">로그인</a>
                    <a href="<c:url value="/member/register.do"/>">회원가입</a>
                </c:when>
                <c:otherwise>
                    <span style="color:white;">${sessionScope.user_id}님 반갑습니다.</span>
                    <a href="<c:url value="/mypage.do"/>">마이페이지</a>
                    <a href="<c:url value="/member/logout.do"/>">로그아웃</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>