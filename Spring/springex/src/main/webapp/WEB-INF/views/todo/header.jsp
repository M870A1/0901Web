<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">Todo</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">할 일 리스트</a>
                        <c:if test="${empty sessionScope.UserId}">
                            <a class="nav-link" href="#">로그인</a>
                            <a class="nav-link" href="#">회원가입</a>
                        </c:if>
                        <c:if test="${not empty sessionScope.UserId}">
                            <a class="nav-link" href="#">로그아웃</a>
                            <a class="nav-link" href="#">할 일 추가</a>
                            <a class="nav-link" href="#">회원탈퇴</a>
                        </c:if>
                        <%--<a class="nav-link disabled">Disabled</a>--%>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
