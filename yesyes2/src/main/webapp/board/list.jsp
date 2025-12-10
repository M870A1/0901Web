<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티 게시판</title>
    <link rel="stylesheet" href="<c:url value='/CSS/common.css'/>">
    <link rel="stylesheet" href="<c:url value='/CSS/community.css'/>"> 
</head>
<body>
	<jsp:include page="/HBox.jsp" />
    <jsp:include page="/header.jsp" />

    <main class="community-container">
        <div class="community-header">
            <h2>커뮤니티</h2>
            <div class="search-box">
                <form method="get">
                    <select name="searchField">
                        <option value="title" ${searchField == 'title' ? 'selected' : ''}>제목</option>
                        <option value="content" ${searchField == 'content' ? 'selected' : ''}>내용</option>
                    </select>
                    <input type="text" name="searchWord" value="${searchWord}" placeholder="검색어 입력"/>
                    <button type="submit" class="btn-search"><i class="fas fa-search"></i></button>
                </form>
            </div>
        </div>

        <table class="board-table">
            <thead>
                <tr>
                    <th style="width: 10%;">번호</th>
                    <th>제목</th>
                    <th style="width: 15%;">작성자</th>
                    <th style="width: 15%;">작성일</th>
                    <th style="width: 10%;">조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty boardList}">
                        <c:forEach items="${boardList}" var="post" varStatus="loop">
                            <tr>
                                <td>${totalCount - (((pageNum - 1) * pageSize) + loop.index)}</td>
                                <td class="title">
                                    <a href="<c:url value='/board/view.do?num=${post.num}'/>">${post.title}</a>
                                </td>
                                <td>${post.author}</td>
                                <td>${post.postdate}</td>
                                <td>${post.visitcount}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5">게시물이 없습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <div class="board-footer">
            <div class="pagination">
                ${pagingImg}
            </div>
            
            <a href="<c:url value='/board/write.do'/>" class="btn-write">글쓰기</a>
        </div>
    </main>

    <jsp:include page="/footer.jsp"/>
</body>
</html>