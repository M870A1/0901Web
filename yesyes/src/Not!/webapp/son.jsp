<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Promoting the Gaem</title>
<link rel="stylesheet" href="/CSS/Son.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

	<jsp:include page="header.jsp" />

	<nav class="main-nav">

		<ul>
			<li><a href="#latest-game">최신 게임</a></li>
			<li><a href="#popular-game">인기 게임</a></li>
			<li><a href="#genre-game">장르별 추천</a></li>
		</ul>
	</nav>
	<main>
		<section id="latest-game">
			<h2>최신 게임</h2>
			<p>
				모두 2025년 하반기 출시되는 기대작으로, 다양한 플랫폼을 지원하며 액션 요소를 중심으로 한 게임들입니다.<br>
				팬들의 큰 관심을 받으며 각기 다른 장르지만 전투와 탐험을 핵심으로 합니다. <br> <span
					class="last-line-translucent">(해당 이미지를 누르시면 해당 사이트로 이동이
					가능합니다.)</span>
			</p>
			<div class="game-list">
				<c:forEach var="game" items="${requestScope.latestGames}">
					<a href="${game.linkUrl}" class="game-card" target="_blank">
					 <img src="${game.imagePath}" alt="${game.title}">
						<div class="game-title">${game.title}</div>
						<div class="game-description">${game.description}</div>
					</a>
				</c:forEach>
				
			</div>
		</section>
		<section id="popular-game">
			<h2>인기 게임</h2>
			<p>
				"Counter-Strike 2", "Baldur’s Gate 3", "Helldivers 2"는 서로 다른 장르임에도
				불구하고 전 세계적으로 큰 인기를 끈 대표적인 게임들입니다.<br> CS2는 정밀한 팀 기반 FPS의 정석,
				Baldur’s Gate 3는 깊이 있는 스토리와 자유도를 갖춘 RPG, Helldivers 2는 협동 전투의 재미를
				극대화한 슈팅 게임으로 사랑받고 있습니다. <br>(해당 이미지를 누르시면 해당 사이트로 이동이 가능합니다.)
			</p>
			<div class="game-list">
				<c:forEach var="game" items="${ requestScope.popularGames }">
					<a href="${ game.linkUrl }" class="game-card" target="_blank"> <img
						src="${ game.imagePath }" alt="${ game.title }">
						<div class="game-title">${ game.title }</div>
					</a>
				</c:forEach>
			</div>
		</section>
		<section id="genre-game">
			<h2>장르별 추천게임</h2>
			<p>
				다양한 게임 장르 중에서 각 장르를 대표하는 인기 게임을 하나씩 선정했습니다. <br>이 게임들은 해당 장르의
				특징을 잘 보여줄 뿐만 아니라, 많은 유저들에게 완성도와 재미를 인정받은 작품들입니다. <br>각 장르는 고유한
				매력을 가지고 있으며, 소개된 게임들은 해당 장르를 처음 접하는 분들에게도 추천할 수 있을 만큼 완성도가 뛰어납니다. <br>(해당
				이미지를 누르시면 해당 사이트로 이동이 가능합니다.)
			</p>
			<div class="game-list">
			<c:forEach var="game" items="${ requestScope.genreGames }">
					<div class="game-title"><a href="${ game.linkUrl }" class="game-card" target="_blank">
					 <img src="${ game.imagePath }" alt="${ game.title }">
						${ game.title }</a>
						</div>
				 </c:forEach>
			</div>
		</section>
	</main>

	<jsp:include page="footer.jsp" />

</body>

</html>