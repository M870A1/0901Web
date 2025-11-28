<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<h1>Promoting the Game!</h1>
	<div class="user-menu">
		<c:choose>
			<c:when test="${not empty sessionScope.user_id}">
			
				<%-- 로그인 상태일 때 --%>
				<span style="color: white;">${sessionScope.user_id}님 반갑습니다.</span>
				<a href="mypage.jsp">마이페이지</a>
				<a href="logout.jsp">로그아웃</a>
			</c:when>
			<c:otherwise>
			
				<%-- 로그아웃 상태일 때 --%>
				<a href="login.jsp">로그인</a>
				<a href="register.jsp">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>
</header>