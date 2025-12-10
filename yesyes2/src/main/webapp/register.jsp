<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="<c:url value="/CSS/register.css"/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
    
    <jsp:include page="/HBox.jsp" />
    <script>
        <c:if test="${not empty errorMsg}">
            alert("${errorMsg}");
        </c:if>
    </script>
    <main>
        <div class="info-column">
            <h2>Promoting The Game!</h2>
            <p>회원이 되어 게임에 대한 당신의 열정을 공유하고, 더 많은 혜택을 누려보세요.</p>
            <ul class="benefits-list">
                <li><i class="fa-solid fa-gamepad"></i> 나만의 게임 라이브러리 관리</li>
                <li><i class="fa-solid fa-star"></i> 게임 평가 및 리뷰 작성</li>
                <li><i class="fa-solid fa-tags"></i> 회원 전용 특별 할인 혜택</li>
                <li><i class="fa-solid fa-comments"></i> 다른 게이머들과의 활발한 소통</li>
            </ul>
        </div>
        <div class="form-column">
            <div class="register-container">
                <h2>회원가입</h2>
                <form class="register-form" action="<c:url value="/member/register.do"/>" method="post">
                    <div class="auth-section">
                        <h3>회원 인증</h3>
                        <div class="member-type">
                            <input type="radio" id="member-individual" name="memberType" value="individual" checked>
                            <label for="member-individual">개인 회원</label>
                            <input type="radio" id="member-business" name="memberType" value="business">
                            <label for="member-business">사업자 회원</label>
                            <input type="radio" id="member-foreign" name="memberType" value="foreign">
                            <label for="member-foreign">외국인 회원</label>
                        </div>
                        <hr>
                        <div class="email-auth">
                            <label><input type="checkbox" name="emailAuth" value="email" checked> 이메일 인증</label>
                            <p class="auth-info">기본정보 > 이메일 항목에 입력하신 정보로 본인인증을 진행합니다.<br>회원가입 후에 인증 메일이 발송되오니, 확인해주시기 바랍니다.</p>
                        </div>
                    </div>
                    <div class="basic-info-section">
                        <h3>기본 정보</h3>
                        <div class="form-group">
                            <label for="reg-id">아이디</label>
                            <input type="text" id="reg-id" name="regId" required>
                        </div>
                        <div class="form-group">
                            <label for="reg-password">비밀번호</label>
                            <input type="password" id="reg-password" name="regPassword" required>
                        </div>
                        <div class="form-group">
                            <label for="reg-confirm-password">비밀번호 확인</label>
                            <input type="password" id="reg-confirm-password" name="regConfirmPassword" required>
                        </div>
                        <div class="form-group">
                            <label for="reg-name">이름</label>
                            <input type="text" id="reg-name" name="regName" required>
                        </div>
                        <div class="form-group">
                            <label for="reg-phone">전화번호</label>
                            <input type="tel" id="reg-phone" name="regPhone" placeholder="'-'를 제외한 숫자만 입력" required pattern="[0-9]*" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
                        </div>
                        <div class="form-group">
                            <label for="reg-email">이메일</label>
                            <input type="email" id="reg-email" name="regEmail" required>
                        </div>
                    </div>
                    <div class="additional-info-section">
                        <h3>추가 정보</h3>
                        <div class="form-group">
                            <label>성별</label>
                            <div class="gender-options">
                                <input type="radio" id="gender-male" name="gender" value="male" checked>
                                <label for="gender-male">남성</label>
                                <input type="radio" id="gender-female" name="gender" value="female">
                                <label for="gender-female">여성</label>
                            </div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <label for="reg-dob">생년월일</label>
                            <input type="text" id="reg-dob" name="regDob" placeholder="2025-09-12" onfocus="this.type='date'" onblur="if(!this.value) { this.type='text'; }">
                        </div>
                    </div>

                    <button type="submit" class="btn-register">회원가입</button>
                </form>
            </div>
        </div>
    </main>
    
 <jsp:include page="footer.jsp"/>
 
</body>
</html>