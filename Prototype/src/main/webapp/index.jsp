<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>고민을 하는 당신을 위한 플랫폼</title>
        <link rel="stylesheet" href="resources/css/style.css">
    </head>

    <body>
        <header>
            <h1><a href="#">고민을 하는 당신을 위한 플랫폼</a></h1>
            <div class="user-menu">
                <a href="#">로그인</a>
                <a href="#">회원가입</a>
            </div>
        </header>

        <nav class="main-nav">
            <ul>
                <li><a href="#">최신 게임</a></li>
                <li><a href="#">인기 게임</a></li>
                <li><a href="#">장르별 추천</a></li>
                <li><a href="#">할인 게임</a></li>
            </ul>
        </nav>

        <main>
            <section id="latest-games">
                <h2>최신 게임</h2>
                <div class="game-list">
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game 1">
                        <div class="game-title">게임 1</div>
                    </div>
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game 2">
                        <div class="game-title">게임 2</div>
                    </div>
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game 3">
                        <div class="game-title">게임 3</div>
                    </div>
                </div>
            </section>

            <section id="popular-games">
                <h2>인기 게임</h2>
                <div class="game-list">
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game A">
                        <div class="game-title">게임 A</div>
                    </div>
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game B">
                        <div class="game-title">게임 B</div>
                    </div>
                    <div class="game-card">
                        <img src="https://via.placeholder.com/300x200" alt="Game C">
                        <div class="game-title">게임 C</div>
                    </div>
                </div>
            </section>
        </main>

        <footer>
            <div class="footer-content">
                <div class="social-icons">
                    <a href="#"><i class="fab fa-facebook-f"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                </div>
                <p>&copy; 2025 Your Game Platform. All rights reserved.</p>
            </div>
            <div class="footer-copyright">
            </div>
        </footer>

        <div class="scroll-remote">
            <button onclick="window.scrollTo(0, 0);">▲ Top</button>
            <button onclick="window.scrollTo(0, document.body.scrollHeight);">▼ Btm</button>
        </div>

    </body>

    </html>