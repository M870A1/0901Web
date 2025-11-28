<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 로그인</title>
  	<link rel="stylesheet" href="<c:url value="/CSS/login.css"/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
    <jsp:include page="/HBox.jsp" />
    <script>
		<c:if test="${not empty errorMessage}">
			alert("${errorMessage}");
		</c:if>
    </script>
    <main>
        <div class="login-container">
            <h2>LOGIN</h2>
            <form class="login-form" action="<c:url value="/member/login.do"/>" method="post">
                <div class="form-group">
                    <label for="username">아이디 또는 이메일</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn-login">로그인</button>
                <div class="signup-prompt">
                    <p>가입한 계정이 없나요?</p>
                </div>
                <div class="links">
                    <a href="#">비밀번호 찾기</a>
                    <a href="<c:url value="/member/register.do"/>">회원가입</a>
                </div>
            </form>
        </div>
    </main>
    <jsp:include page="footer.jsp"/>
</body>
</html>
